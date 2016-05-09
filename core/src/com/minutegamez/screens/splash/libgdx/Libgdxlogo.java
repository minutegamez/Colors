package com.minutegamez.screens.splash.libgdx;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.guiassets.SplashAssets;
import com.minutegamez.utils.Constants;

public class Libgdxlogo extends ImageGameObject {
	public Libgdxlogo() {
		TextureRegion region = SplashAssets.libgdx_logo;
		setRegion(region, region.getRegionWidth(), region.getRegionHeight());
		setPosition(Constants.GUI_WIDTH / 2 - getWidth() / 2,
				Constants.GUI_HEIGHT / 2 - getHeight() / 2);
	}
}
