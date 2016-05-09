package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.framework.ImageGameObject;

public class DisplayFish extends ImageGameObject {

	private TextureRegion region = ColorFishingAsset.instance.gameAsset.emptyFish;

	private int colorIndex;
	
	public DisplayFish() {
		setRegion(region);
	}

	public int getColorIndex() {
		return colorIndex;
	}

	public void setColorIndex(int colorIndex) {
		this.colorIndex = colorIndex;
	}
	
	
}
