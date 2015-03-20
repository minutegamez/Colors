package com.minutegamez.screens.menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.minutegamez.guiassets.BackgroundAssets;
import com.minutegamez.utils.Constants;

public class Background extends Actor {
	private TextureRegion region;

	public Background() {
		region = BackgroundAssets.grass_background;
		setBounds(0, 0, Constants.GUI_WIDTH, Constants.GUI_HEIGHT);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation());
	}

}
