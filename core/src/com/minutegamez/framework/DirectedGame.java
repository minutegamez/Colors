package com.minutegamez.framework;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.minutegamez.screens.transition.ScreenTransition;

public class DirectedGame implements ApplicationListener {

	private Screen currScreen;
	private Screen nextScreen;

	private FrameBuffer currFbo;
	private FrameBuffer nextFbo;

	private boolean init;

	private ScreenTransition screenTransition;

	private float t;

	private SpriteBatch batch;

	public void setScreen(Screen screen) {
		setScreen(screen, null);
	}

	public void setScreen(Screen screen, ScreenTransition screenTransition) {
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();

		if (!init) {
			currFbo = new FrameBuffer(Format.RGB888, width, height, false);
			nextFbo = new FrameBuffer(Format.RGB888, width, height, false);
			batch = new SpriteBatch();
			init = true;
		}

		nextScreen = screen;
		nextScreen.show(); // activate next screen
		nextScreen.resize(width, height);
		nextScreen.render(0); // let screen update() once
		if (currScreen != null)
			currScreen.pause();
		nextScreen.pause();
		Gdx.input.setInputProcessor(null); // disable input
		this.screenTransition = screenTransition;
		t = 0;
	}

	@Override
	public void create() {

	}

	@Override
	public void resize(int width, int height) {
		if (currScreen != null) {
			currScreen.resize(width, height);
		}
	}

	@Override
	public void render() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		// no transition
		if (nextScreen == null) {
			if (currScreen != null) {
				currScreen.render(deltaTime);
			}
			// transition
		} else {

			float duration = 0;

			if (screenTransition != null) {
				duration = screenTransition.getDuration();
			}

			t = Math.min(t + deltaTime, duration);

			if (screenTransition == null || t >= duration) {
				// finished transition / no transition effect
				if (currScreen != null) {
					currScreen.hide();
				}
				nextScreen.resume();
				currScreen = nextScreen;
				nextScreen = null;
				screenTransition = null;
			} else {
				// ongoing transition
				currFbo.begin();
				if (currScreen != null) {
					currScreen.render(deltaTime);
				}
				currFbo.end();
				nextFbo.begin();
				if (nextScreen != null) {
					nextScreen.render(deltaTime);
				}
				nextFbo.end();
				float alpha = t / duration;
				screenTransition.render(batch, currFbo.getColorBufferTexture(),
						nextFbo.getColorBufferTexture(), alpha);
			}
		}
	}

	@Override
	public void pause() {
		if (currScreen != null) {
			currScreen.pause();
		}
	}

	@Override
	public void resume() {
		if (currScreen != null) {
			currScreen.resume();
		}
	}

	@Override
	public void dispose() {
		if (currScreen != null)
			currScreen.dispose();
		if (nextScreen != null)
			nextScreen.dispose();
		if (init) {
			currFbo.dispose();
			currScreen = null;
			nextFbo.dispose();
			nextScreen = null;
			batch.dispose();
			init = false;
		}
	}
}
