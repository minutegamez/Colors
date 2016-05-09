package com.minutegamez.screens.splash.title;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.utils.Constants;

public class ColorsLabel extends ImageGameObject {
	public ColorsLabel() {
		TextureRegion region = SplashAssets.colorsLabel;
		setRegion(region, region.getRegionWidth(), region.getRegionHeight());
		setPosition(Constants.GUI_WIDTH + getWidth(), 300);
	}
}
