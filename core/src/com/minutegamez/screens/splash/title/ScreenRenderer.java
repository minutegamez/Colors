package com.minutegamez.screens.splash.title;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.framework.Renderer;

public class ScreenRenderer implements Renderer {

	private TitleSplash screen;

	public ScreenRenderer(TitleSplash screen) {
		this.screen = screen;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		screen.background.render(batch);
		screen.colorsLabel.render(batch);
		screen.forKidsLabel.render(batch);
		batch.end();
	}

}
