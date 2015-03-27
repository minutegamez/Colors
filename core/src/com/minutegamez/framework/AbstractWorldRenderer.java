package com.minutegamez.framework;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.utils.Constants;

public abstract class AbstractWorldRenderer {

	protected OrthographicCamera camera;

	public AbstractWorldRenderer() {
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

	public abstract void render(SpriteBatch batch);
}
