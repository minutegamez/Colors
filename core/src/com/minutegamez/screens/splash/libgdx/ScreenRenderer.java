package com.minutegamez.screens.splash.libgdx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.framework.Renderer;

public class ScreenRenderer implements Renderer {

	private LibgdxSplash screen;

	public ScreenRenderer(LibgdxSplash screen) {
		this.screen = screen;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		screen.libgdxlogo.draw(batch, 1f);
		batch.end();
	}

}
