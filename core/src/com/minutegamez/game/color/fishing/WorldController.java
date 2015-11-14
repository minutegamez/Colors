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
	public MovingStarsEffect movingStarsParticle;

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
		if (!soundManager.isRunning()) {
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
				scoreManager.update();
			}
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
	
		movingStarsParticle = new MovingStarsEffect(tweenManager);
		groupObject.add(background);
		groupObject.add(clouds);
		groupObject.add(frontCorals);
		groupObject.add(tank);
		groupObject.add(bubbles);
		groupObject.add(upperSeaObjects);
		// groupObject.add(displayFishes);
		groupObject.add(movingStarsParticle);
	}

	@Override
	public void touchDown(Vector3 touchPoint) {
		checkFishCollission(touchPoint);
	}

	private void startCorrectAnimation(Fish fish) {
		ImageGameObject dFish = displayFishes.getEmptyFish();
		movingStarsParticle.setFishRegion(fish.getRegion());
		movingStarsParticle.setPosition(fish.getX() + fish.getWidth() / 2,
				fish.getY() + fish.getHeight() / 2);
		movingStarsParticle.setDestination(dFish.getX() + dFish.getWidth() / 2,
				dFish.getY() + dFish.getHeight() / 2);
		movingStarsParticle.start();
	}

	private void checkFishCollission(Vector3 touchPoint) {
		for (Fish fish : tank.fishesOnScreen) {
			if (collided(fish, touchPoint)) {
				// if correct fish is tapped
				if (tank.ifFishIsATarget(fish)) {
					tank.remove(fish);
					startCorrectAnimation(fish);
					// if all target fishes are tapped
					if (tank.isTargetFishEmpty()) {
						scoreManager.addScore(true);
						soundManager.playCorrectSound();
					}
					break;
					// if incorrect fish is tapped
				} else {
					scoreManager.addScore(false);
					scoreManager.setError(tank.getTargetColor());
					soundManager.playIncorrectSound(fish.colorIndex);
					// soundManager.
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
