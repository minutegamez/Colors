package com.minutegamez.screens.splash.libgdx;

import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.test.ImageGameObject;
import com.minutegamez.utils.Constants;

public class Libgdxlogo extends ImageGameObject {
	public Libgdxlogo() {
		setRegion(SplashAssets.libgdx_logo);
		setDimension(getRegion().getRegionWidth(), getRegion()
				.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2 - getWidth() / 2,
				Constants.GUI_HEIGHT / 2 - getHeight() / 2);
	}
}
