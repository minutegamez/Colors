package com.minutegamez.screens.splash.ubuntu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.framework.Renderer;

public class ScreenRenderer implements Renderer{

	private UbuntuSplash screen;

	public ScreenRenderer(UbuntuSplash screen){
		this.screen = screen;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		screen.libgdxlogo.render(batch);
		batch.end();
	}

}
