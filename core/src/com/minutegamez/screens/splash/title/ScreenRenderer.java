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
		screen.background.draw(batch, 1f);
		screen.colorsLabel.draw(batch, 1f);
		screen.forKidsLabel.draw(batch, 1f);
		batch.end();
	}

}
