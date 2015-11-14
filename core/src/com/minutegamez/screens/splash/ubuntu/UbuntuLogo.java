package com.minutegamez.screens.splash.ubuntu;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.utils.Constants;

public class UbuntuLogo extends ImageGameObject {
	public UbuntuLogo() {
		TextureRegion region = SplashAssets.ubuntu_logo;
		setRegion(SplashAssets.ubuntu_logo, region.getRegionWidth(),
				region.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2 - getWidth() / 2,
				Constants.GUI_HEIGHT / 2 - getWidth() / 2);
	}
}
