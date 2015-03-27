package com.minutegamez.screens.splash.ubuntu;

import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.test.ImageGameObject;
import com.minutegamez.utils.Constants;

public class UbuntuLogo extends ImageGameObject {
	public UbuntuLogo() {
		setRegion(SplashAssets.ubuntu_logo);
		setDimension(getRegion().getRegionWidth(), getRegion()
				.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2 - getWidth() / 2,
				Constants.GUI_HEIGHT / 2 - getWidth() / 2);
	}
}
