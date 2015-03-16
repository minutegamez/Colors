package com.minutegamez.screens.splash.title;

import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.test.ImageGameObject;
import com.minutegamez.utils.Constants;

public class Background extends ImageGameObject {
	public Background() {
		setRegion(SplashAssets.background);
		dimension.set(getRegion().getRegionWidth(), getRegion()
				.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2 - dimension.x / 2,
				Constants.GUI_HEIGHT / 2 - dimension.y / 2);
	}
}
