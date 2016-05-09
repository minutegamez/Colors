package com.minutegamez.screens.splash.title;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.utils.Constants;

public class ForKidsLabel extends ImageGameObject {
	public ForKidsLabel() {
		TextureRegion region = SplashAssets.forKidsLabel;
		setRegion(SplashAssets.forKidsLabel, region.getRegionWidth(), region.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2, Constants.GUI_HEIGHT / 2);
		setOrigin(getWidth()/ 2, getHeight() / 2);
		setScale(1.5f, 1.5f);
		getColor().a = 0;
	}
}