package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.math.Vector3;
import com.minutegamez.framework.AbstractWorldController;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.framework.ScoreManager;
import com.minutegamez.game.color.fishing.LevelService.Level;

public class WorldController extends AbstractWorldController {

	private Background background;
	private Bubbles bubbles;
	public UpperSeaObjects upperSeaObjects;
	public FrontCorals frontCorals;
	public Clouds clouds;

	// Game Objects
	private GroupObject buttonList;
	public Tank tank;
	// public ColorsQueueTemp colorsQueue;
	public SoundManager soundManager;
	public ScoreManager scoreManager;
	public DisplayFishes displayFishes;
	public Level level;

	private boolean incorrectAdded;

	@Override
	public void init() {
	}

	public void init(Level level) {
		this.level = level;
		tank.init(level);
		displayFishes.init(level.getTargetFish());
		Boat boat = upperSeaObjects.getBoat();
		boat.init(level.getColorsToFind().size);
	}

	private void setObjectPositions() {

	}

	public void resume() {
		setState(STATE_RUNNING);
	}

	private void updateTank(float deltaTime) {
			if (tank.state == Tank.STATE_EMPTY) {
				if (tank.isTargetQueueEmpty()) {
					state = STATE_LEVEL_END;
				} else {
					tank.generateFishes();
					int targetColor = tank.getTargetColor();
					displayFishes.reset(targetColor);
					soundManager.playInstructionSound(targetColor);
				}
				// update the score(add errors if there is an incorrect
				// attemptperformed)
				// scoreManager.update();
		}
	}

	public void onGameStart() {

	}

	public WorldController(TweenManager tweenManager) {
		super(tweenManager);
		background = new Background();
		bubbles = new Bubbles(tweenManager);
		soundManager = new SoundManager();
		scoreManager = new ScoreManager();
		tank = new Tank(tweenManager);
		displayFishes = new DisplayFishes(tweenManager);
		upperSeaObjects = new UpperSeaObjects(tweenManager);
		frontCorals = new FrontCorals();
		clouds = new Clouds();

		groupObject.add(background);
		groupObject.add(clouds);
		groupObject.add(tank);
		groupObject.add(bubbles);
		groupObject.add(upperSeaObjects);
		groupObject.add(frontCorals);
		// groupObject.add(displayFishes);
	}

	@Override
	public void touchDown(Vector3 touchPoint) {
		checkFishCollission(touchPoint);
	}

	private void startCorrectAnimation(Fish fish, Monkey monkey) {
		tank.remove(fish);
		soundManager.playClickSound();
		// startCorrectAnimation(fish);
		// if all target fishes are tapped
		if (tank.isTargetFishEmpty()) {
			monkey.setToHappy();
			scoreManager.addScore(true);
			soundManager.playCorrectSound();
		}

		ImageGameObject dFish = displayFishes.getEmptyFish();
		fish.startOnCaughtAnim(dFish.getX() + dFish.getWidth() / 2,
				dFish.getY() + dFish.getHeight() / 2);

	}

	private void checkFishCollission(Vector3 touchPoint) {
		Monkey monkey = upperSeaObjects.getBoat().getMonkey();
		
		if (tank.state == Tank.STATE_NORMAL) {
			for (int j = tank.fishesOnScreen.size - 1; j > -1; j--) {
				Fish fish = tank.fishesOnScreen.get(j);
				if (collided(fish, touchPoint)
						&& fish.getState() == Fish.STATE_SWIMMING) {
					// if correct fish is tapped
					if (tank.ifFishIsATarget(fish)) {
						startCorrectAnimation(fish, monkey);
					} else {
						// if incorrect fish is tappeds
						monkey.setToAngry();
						scoreManager.addScore(false);
						scoreManager.setError(tank.getTargetColor());
						soundManager.playIncorrectSound(fish.colorIndex);
						// soundManager.
					}
					break;
				}
			}
		}
	}

	@Override
	public void update(float deltaTime) {
		switch (getState()) {
		case STATE_PAUSED:
			break;
		case STATE_RUNNING:
			tweenManager.update(deltaTime);
			// movingStarsParticle.update(deltaTime);
			groupObject.update(deltaTime);
			updateTank(deltaTime);
			soundManager.update(deltaTime);
			break;
		default:
			break;
		}
	}

}
