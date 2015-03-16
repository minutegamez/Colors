package com.minutegamez.screens.splash.ubuntu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.minutegamez.framework.DirectedGame;
import com.minutegamez.framework.Renderer;
import com.minutegamez.framework.SplashScreen;
import com.minutegamez.guiassets.GUIAssets;
import com.minutegamez.screens.splash.title.TitleSplash;
import com.minutegamez.screens.transition.ScreenTransition;
import com.minutegamez.screens.transition.ScreenTransitionFade;
import com.minutegamez.test.GameObject;

public class UbuntuSplash extends SplashScreen {

	private float duration = 3.0f;
	private float stateTime = 0.0f;
	private Renderer renderer;

	private GUIAssets guiAssets;

	public GameObject libgdxlogo;

	public UbuntuSplash(DirectedGame game) {
		super(game);
		loadAssets();
		libgdxlogo = new UbuntuLogo();
		renderer = new ScreenRenderer(this);
		state = State.PLAYING;
	}

	private void loadAssets() {
		guiAssets = new GUIAssets();
		guiAssets.load();
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		renderer.render(batch);
	}

	private void update(float delta) {
		switch (state) {
		case PAUSED:
			break;
		case PLAYING:
			stateTime += delta;
			if (stateTime >= duration) {
				ScreenTransition screenTransition = new ScreenTransitionFade();
				game.setScreen(new TitleSplash(game), screenTransition);
				state = State.PAUSED;
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}