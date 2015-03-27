package com.minutegamez.game.color.fishing;

import com.minutegamez.framework.AbstractGameObject;
import com.minutegamez.guiassets.BackgroundAssets;
import com.minutegamez.utils.Constants;

public class Background extends AbstractGameObject {

	public Background() {
		setRegion(BackgroundAssets.grass_background);
		setDimension(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		setPosition(0, 0);
	}
}
