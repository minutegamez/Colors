package com.minutegamez.screens.splash.title;

import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.test.ImageGameObject;
import com.minutegamez.utils.Constants;

public class ForKidsLabel extends ImageGameObject {
	public ForKidsLabel() {
		setRegion(SplashAssets.forKidsLabel);
		setDimension(getRegion().getRegionWidth(), getRegion()
				.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2, Constants.GUI_HEIGHT / 2);
		setOrigin(getWidth()/ 2, getHeight() / 2);
		setScale(1.5f, 1.5f);
		getColor().a = 0;
	}
}