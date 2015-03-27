package com.minutegamez.screens.splash.title;

import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.test.ImageGameObject;
import com.minutegamez.utils.Constants;

public class Background extends ImageGameObject {
	public Background() {
		setRegion(SplashAssets.background);
		setDimension(getRegion().getRegionWidth(), getRegion()
				.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2 - getWidth() / 2,
				Constants.GUI_HEIGHT / 2 - getWidth() / 2);
	}
}
