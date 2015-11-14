package com.minutegamez.framework;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractScreen extends InputAdapter implements Screen {

	public static final int STATE_RUNNING = 102;
	public static final int STATE_PAUSED = 103;

	protected int state;
	protected PopupStage currScreen = null;

	public void pause() {
		state = STATE_PAUSED;
		System.out.println("paused");
	}

	public void resume() {
		state = STATE_RUNNING;
		System.out.println("runnin");
	}

	protected void setState(int state) {
		this.state = state;
	}

	public PopupStage getPopup(){
		return currScreen;
	}
	
	public void setPopup(PopupStage stage) {
		currScreen = stage;
		currScreen.show();
		System.out.println("s");
	}

	protected DirectedGame game;
	protected SpriteBatch batch;

	public AbstractScreen(DirectedGame game) {
		this.game = game;
		batch = new SpriteBatch();
	}

	@Override
	public void show() {

	}

	public void render(float delta) {
		if (state == STATE_RUNNING) {
			update(delta);
		}
		draw();
	}

	public abstract void draw();

	public abstract void update(float delta);

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}

	public void setInputProcessor() {

	}

	public InputProcessor getInputProcessor() {
		return null;
	}

}
