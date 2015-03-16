package com.minutegamez.framework;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.minutegamez.utils.Constants;

public abstract class SplashScreen implements Disposable, Screen {

	protected State state;
	protected DirectedGame game;
	protected SpriteBatch batch;
	protected OrthographicCamera camera;

	public SplashScreen(DirectedGame game) {
		this.game = game;
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.GUI_WIDTH,
				Constants.GUI_HEIGHT);
		camera.position.set(Constants.GUI_WIDTH / 2, Constants.GUI_HEIGHT / 2,
				0);
		camera.update();
	}

	public enum State {
		PAUSED, PLAYING
	}

	@Override
	public void show() {

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

	public void dispose() {
		batch.dispose();
	}

	public abstract void render(float delta);

}
