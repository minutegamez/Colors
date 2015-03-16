package com.minutegamez.screens.splash.title;

import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.test.ImageGameObject;
import com.minutegamez.utils.Constants;

public class ColorsLabel extends ImageGameObject {
	public ColorsLabel() {
		setRegion(SplashAssets.colorsLabel);
		dimension.set(getRegion().getRegionWidth(), getRegion()
				.getRegionHeight());
		setPosition(Constants.GUI_WIDTH + dimension.x, 300);
	}
}
