package com.minutegamez.screens.splash.title;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.utils.Constants;

public class Background extends ImageGameObject {
	public Background() {
		TextureRegion region = SplashAssets.background;
		setRegion(SplashAssets.background, region.getRegionWidth(),
				region.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2 - getWidth() / 2,
				Constants.GUI_HEIGHT / 2 - getWidth() / 2);
	}
}
