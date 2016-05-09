package com.minutegamez.framework;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.utils.Constants;

public abstract class AbstractGameScreen extends AbstractScreen implements
		Screen {

	// state starts from 100


	protected InputMultiplexer inputMultiplexer;
	protected TweenManager tweenManager;
	protected TweenManager guiTweenManager;

	protected PopupStage pauseScreen;
	protected PopupStage levelEndScreen;
	protected PopupStage gameOverScreen;
	protected PopupStage tutorialScreen;
	protected PopupStage readyScreen;
	protected PopupStage levelScreen;
	protected PopupStage loadingScreen;

	protected PopupStage runningScreen;

	protected OrthographicCamera guiCam;

	protected AbstractWorldRenderer worldRenderer;

	// protected boolean gameStarted;

	public AbstractGameScreen(DirectedGame game) {
		super(game);
		batch = new SpriteBatch();
		inputMultiplexer = new InputMultiplexer();
		guiCam = new OrthographicCamera(Constants.GUI_WIDTH,
				Constants.GUI_HEIGHT);
		guiCam.update();

		guiTweenManager = new TweenManager();

		// init tween
		tweenManager = new TweenManager();

		// init popups

		// gameStarted = true;
	}

	public abstract void draw();

	public abstract void update(float delta);




	@Override
	public void render(float delta) {
		update(delta);
		draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println("x");
		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public abstract void dispose();

	public InputProcessor getInputProcessor() {
		return inputMultiplexer;
	}

}
