package com.minutegamez.framework;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class AbstractGameScreen extends InputAdapter implements Screen {

	// state starts from 100

	public static final int RUNNING = 100;
	public static final int PAUSED = 101;
	public static final int RESUMED = 102;

	protected int state;
	protected DirectedGame game;
	protected SpriteBatch batch;
	protected Vector3 touchPoint;
	protected TweenManager tweenManager;

	protected PopupStage pauseScreen;
	protected PopupStage levelEndScreen;
	protected PopupStage gameOverScreen;
	protected PopupStage tutorialScreen;
	protected PopupStage readyScreen;
	protected PopupStage levelScreen;

	protected PopupStage currPopUp;
	protected PopupStage runningPopup;

	protected AbstractWorldRenderer worldRenderer;
	protected AbstractWorldController worldController;

	// protected boolean gameStarted;

	public AbstractGameScreen(DirectedGame game) {
		this.game = game;
		batch = new SpriteBatch();
		touchPoint = new Vector3();

		// init tween
		tweenManager = new TweenManager();
		Tween.registerAccessor(AbstractGameObject.class, new ObjectAccessor());

		// init popups

		// gameStarted = true;
	}

	public abstract void draw();

	public abstract void update(float delta);

	@Override
	public void show() {

	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

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

	@Override
	public void hide() {

	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public void dispose() {

	}

	public abstract InputProcessor getInputProcessor();

}
