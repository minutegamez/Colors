package com.minutegamez.framework;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GUIScreen extends AbstractScreen {

	protected State state;

	protected enum State {
		PAUSED, RESUMED,
	}

	public GUIScreen(DirectedGame game) {
		super(game);
		batch = new SpriteBatch();
	}

	@Override
	public void show() {

	}

	public abstract void render(float delta);

	public abstract void resize(int width, int height);

	public abstract void pause();

	public abstract void resume();

	public abstract void hide();

	public abstract void dispose();

	public abstract void draw();

	public abstract void update(float delta);

	public abstract InputProcessor getInputProcessor();

}
