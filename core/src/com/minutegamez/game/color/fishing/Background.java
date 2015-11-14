package com.minutegamez.game.color.fishing;

import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.guiassets.BackgroundAssets;
import com.minutegamez.utils.Constants;

public class Background extends ImageGameObject {

	public Background() {
		setRegion(ColorFishingAsset.instance.gameAsset.background);
		setPosition(0, 0);
	}
}
