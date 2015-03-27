package com.minutegamez.framework;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractScreen extends InputAdapter implements Screen{

	protected DirectedGame game;
	protected SpriteBatch batch;

	public AbstractScreen(DirectedGame game) {
		this.game = game;
		batch = new SpriteBatch();
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {

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

	@Override
	public void dispose() {

	}

	public abstract void setInputProcessor();

}
