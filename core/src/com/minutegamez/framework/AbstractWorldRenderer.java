package com.minutegamez.framework;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.utils.Constants;

public abstract class AbstractWorldRenderer {

	protected OrthographicCamera camera;
	protected SpriteBatch batch;

	public AbstractWorldRenderer(SpriteBatch batch) {
		this.batch = batch;
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,
				Constants.VIEWPORT_HEIGHT);
		camera.position.set(Constants.VIEWPORT_WIDTH / 2,
				Constants.VIEWPORT_HEIGHT / 2, 0);
		camera.update();
	}

	public void resize(int width, int height) {
		camera.position.set(Constants.VIEWPORT_WIDTH / 2,
				Constants.VIEWPORT_HEIGHT / 2, 0);
		camera.update();
	}

	public abstract void render();
}
