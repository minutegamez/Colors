package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Sine;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.game.color.fishing.LevelService.Level;
import com.minutegamez.utils.Constants;

public class Tank extends ImageGameObject {

	public static final int MAX_FISH = 10;

	public static final int STATE_EMPTY = 101;
	public static final int STATE_NORMAL = 102;
	public static final int STATE_ON_EXIT = 103;

	private TweenManager tweenManager;

	public int state;

	private Level level;
	// base fishes
	public final Array<Fish> fishPool;
	// visible fishes on screen
	public Array<Fish> fishesOnScreen;
	// target fishes on batch
	public int targetFishesCount;
	// public Array<Fish> targetFishes;

	public ColorsQueue colorsQueue;

	public int targetFishColorID;

	public Tank(TweenManager tweenManager) {
		this.tweenManager = tweenManager;
		fishPool = new Array<Fish>();
		colorsQueue = new ColorsQueue();
		fishesOnScreen = new Array<Fish>();

		Array<ParticleEffect> effects = ColorFishingAsset.instance.particleAsset.fishBubbleParticle;
		
		for (int j = 0; j < MAX_FISH; j++) {
			ParticleEffect effect = effects.get(j);  
			Fish fish = new Fish(effect);
			fishPool.add(fish);
		}
	}

	public void generateFishes() {

		int size = level.getVisibleFishOnTank();
		int numOfTargets = level.getTargetFish();
		targetFishesCount = level.getTargetFish();
		targetFishColorID = colorsQueue.getTargetColor();
		float x = Constants.VIEWPORT_WIDTH;
		float y = Constants.VIEWPORT_HEIGHT - fishPool.get(0).getHeight()
				* 1.5f;
		for (int j = 0; j < size; j++) {

			int index = targetFishColorID;
			Fish fish = fishesOnScreen.get(j);

			// set color
			// add the targetFish first
			// generate random fish color on others
			if (j < numOfTargets) {
				index = targetFishColorID;
			} else {
				do {
					index = MathUtils.random(Constants.MAX_COLOR - 1);
				} while (index == targetFishColorID);
			}
			fish.colorIndex = index;

			// type
			fish.setType(level.getFishType());

			// speed
			fish.speed = MathUtils.random(level.getMinSpeed(),
					level.getMaxSpeed());

			// position
			fish.setPosition(
					x,
					y
							+ MathUtils.random(-fish.getHeight() / 5,
									fish.getHeight() / 5));

			y -= fish.getHeight();

			fish.reset();
			
			// if a fish will not make it send to the next column position
			if (y <= 0) {
				y = Constants.VIEWPORT_HEIGHT - fish.getHeight()
						* MathUtils.random(1, 2);
				x += fish.getWidth() * 1.5f;
			}
			
		}
		colorsQueue.next();
		setState(STATE_NORMAL);
	}

	public void setState(int state) {
		this.state = state;
	}

	public boolean isTargetFishEmpty() {
		return targetFishesCount == 0;
	}

	public void spawnFishes() {
		for (Fish fish : fishesOnScreen) {
			Tween.to(fish, ActorAccessor.POS_X, 2.0F).target(fish.getX() - 4)
					.ease(Sine.IN).start(tweenManager);
		}
	}

	public void exit() {
		for (Fish fish : fishesOnScreen) {
			fish.speed += 6f;
		}
		setState(STATE_ON_EXIT);
	}

	// init on start of level
	public void init(Level level) {
		this.level = level;
		colorsQueue.init(level.getColorsToFind());
		fishesOnScreen.clear();
		targetFishesCount = level.getTargetFish();

		int fishOnTank = level.getVisibleFishOnTank();
		for (int j = 0; j < fishOnTank; j++) {
			Fish fish = fishPool.get(j);
			fishesOnScreen.add(fish);
		}
		setState(STATE_NORMAL);
	}

	public void update(float deltaTime) {
		System.out.println("pdate tank");
		if (state == STATE_NORMAL || state == STATE_ON_EXIT) {
			boolean allFishExited = true;
			for (Fish fish : fishesOnScreen) {
				fish.update(deltaTime);
				if (fish.state != Fish.STATE_NOT_VISIBLE) {
					allFishExited = false;
				}
			}

			// CHECK IF TARGET FISHES ARE EMPTY
			if (state == STATE_NORMAL) {
				if (isTargetFishEmpty()) {
					makeFishesExit();
				}
			}

			// CHECK IF ALL FISH ARE OUT OF THE SCREEN
			if (allFishExited) {
				setState(STATE_EMPTY);
			}
		}
	}

	private void makeFishesExit() {
		for (Fish fish : fishesOnScreen) {
			fish.speed = 6f;
		}

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (Fish fish : fishesOnScreen) {
			if (fish.state != Fish.STATE_NOT_VISIBLE) {
				fish.draw(batch, parentAlpha);
			}
		}
	}

	public boolean isTargetQueueEmpty() {
		return colorsQueue.isEmpty();
	}

	public int getTargetColor() {
		return targetFishColorID;
	}

	public boolean ifFishIsATarget(Fish fish) {
		return (fish.state == Fish.STATE_SWIMMING && fish.colorIndex == getTargetColor());
	}

	public void remove(Fish fish) {
		fish.state = Fish.STATE_ON_EXIT;
		targetFishesCount--;
	}
}
