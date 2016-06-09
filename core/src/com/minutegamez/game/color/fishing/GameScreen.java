package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.minutegamez.framework.AbstractGameScreen;
import com.minutegamez.framework.DirectedGame;
import com.minutegamez.framework.popup.InstructionService;
import com.minutegamez.framework.popup.LevelEndStage;
import com.minutegamez.framework.popup.LevelStage;
import com.minutegamez.framework.popup.LoadingStage;
import com.minutegamez.framework.popup.PauseStage;
import com.minutegamez.framework.popup.ReadyStage;
import com.minutegamez.framework.popup.RunningStage;
import com.minutegamez.framework.popup.TutorialStage;
import com.minutegamez.screens.profile.Profile;

public class GameScreen extends AbstractGameScreen {

	private WorldController worldController;
	private LevelService levelService;

	private boolean loaded = false;

	private int gameIndex = Profile.GAME_FISHING;

	public GameScreen(DirectedGame game) {
		super(game);

		levelService = new LevelService();

		loadingScreen = new LoadingStage(batch, guiTweenManager,
				ColorFishingAsset.instance);
		levelEndScreen = new LevelEndStage(batch, guiTweenManager);
		runningScreen = new RunningStage(batch, guiTweenManager);
		readyScreen = new ReadyStage(batch, guiTweenManager);
		levelScreen = new LevelStage(batch, guiTweenManager, gameIndex);
		tutorialScreen = new TutorialStage(batch, guiTweenManager,
				new InstructionService());
		pauseScreen = new PauseStage(batch, guiTweenManager);
	}

	private void init() {
		worldController = new WorldController(tweenManager);
		worldRenderer = new WorldRenderer(batch, worldController);
		loaded = true;
		inputMultiplexer.addProcessor(runningScreen);
		inputMultiplexer.addProcessor(worldController);
	}

	@Override
	public void draw() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (loaded) {
			worldRenderer.render();
		}
		if (currScreen != null) {
			currScreen.draw();
		}
	}

	@Override
	public void update(float delta) {
		guiTweenManager.update(delta);

		if (currScreen != null) {
			// ready
			if (currScreen.equals(readyScreen)) {
				checkReadyStageResponse();
			}
			// running
			else if (currScreen.equals(runningScreen)) {
				worldController.update(delta);
				checkRunningStageResponse();
			}
			// pause
			else if (currScreen.equals(pauseScreen)) {
				checkPauseStageResponse();
			}
			// tutorial
			else if (currScreen.equals(tutorialScreen)) {
				checkTutorialStageResponse();
			}
			// level
			else if (currScreen.equals(levelScreen)) {
				checkLevelStageResponse();
			}
			// level end
			else if (currScreen.equals(levelEndScreen)) {
				checkLevelEndStageResponse();
			}

			// loading
			else if (currScreen.equals(loadingScreen)) {
				checkLoadingResponse();
			}
		}
	}

	private void checkLevelEndStageResponse() {
		switch (levelEndScreen.getResponse()) {
		case LevelEndStage.RESPONSE_BACK_TO_MENU:
			System.out.println("back to menu");
			break;
		case LevelEndStage.RESPONSE_NEXT:
			System.out.println("next");
			break;
		case LevelEndStage.RESPONSE_REPLAY:
			setPopup(readyScreen);
//			worldController.init(levelService.getCurrLevel());
			break;
		case LevelEndStage.RESPONSE_BACK_TO_LEVEL_SELECTION:
			System.out.println("back to level selectin");
			break;
		}
	}

	private void checkLoadingResponse() {
		switch (loadingScreen.getResponse()) {
		case LoadingStage.RESPONSE_LOADING_FINISHED:
			init();
			setPopup(levelScreen);
			break;
		}
	}

	private void checkLevelStageResponse() {
		switch (levelScreen.getResponse()) {
		case LevelStage.RESPONSE_LEVEL_SELECTED:
			setPopup(readyScreen);
			worldController.init(levelService.getCurrLevel());
			break;
		}
	}

	private void checkTutorialStageResponse() {
		switch (pauseScreen.getResponse()) {
		case TutorialStage.RESPONSE_PLAY:
			setPopup(runningScreen);
			break;
		}
	}

	private void checkPauseStageResponse() {
		switch (pauseScreen.getResponse()) {
		case PauseStage.RESPONSE_HELP:
			break;
		case PauseStage.RESPONSE_QUIT:
			break;
		case PauseStage.RESPONSE_RESUME:
			setPopup(runningScreen);
			break;
		}
	}

	private void checkRunningStageResponse() {
		switch (runningScreen.getResponse()) {
		case RunningStage.RESPONSE_PAUSE:
			setPopup(pauseScreen);
			return;
		}

		checkWorldState();
	}

	private void checkWorldState() {
		switch (worldController.getState()) {
		case WorldController.STATE_LEVEL_END:
			int numOfStars = worldController.scoreManager.getNumOfStars();
			worldController.scoreManager.save();

			LevelEndStage stage = (LevelEndStage) levelEndScreen;
			stage.init(numOfStars);

			setPopup(levelEndScreen);
			break;
		}
	}

	private void checkReadyStageResponse() {
		switch (readyScreen.getResponse()) {
		case ReadyStage.RESPONSE_ANIMATION_FINISHED:
			setPopup(runningScreen);
			worldController.resume();
			break;
		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		if (currScreen != null) {
			currScreen.getViewport().update(width, height);
		}
	}

	@Override
	public void resume() {
		setPopup(loadingScreen);
		// worldController.init();
		super.resume();
	}

	@Override
	public void dispose() {
		loadingScreen.dispose();
	}

}
