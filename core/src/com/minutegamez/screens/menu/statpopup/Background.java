package com.minutegamez.screens.menu.statpopup;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.minutegamez.guiassets.ProfileAssets;

public class Background extends Image {

	private TextureRegion region;

	public Background() {
		this.region = StatAssets.background;
		setDrawable(new TextureRegionDrawable(region));
		setSize(region.getRegionWidth(), region.getRegionHeight());
	}
}
