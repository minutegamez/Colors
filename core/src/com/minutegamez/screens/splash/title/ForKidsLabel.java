package com.minutegamez.screens.splash.title;

import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.test.ImageGameObject;
import com.minutegamez.utils.Constants;

public class ForKidsLabel extends ImageGameObject {
	public ForKidsLabel() {
		setRegion(SplashAssets.forKidsLabel);
		dimension.set(getRegion().getRegionWidth(), getRegion()
				.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2, Constants.GUI_HEIGHT / 2);
		origin.set(dimension.x / 2, dimension.y / 2);
		scale.set(1.5f, 1.5f);
		color.a = 0;
	}
}