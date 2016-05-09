package com.minutegamez.framework;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.utils.Constants;

public class GameObject extends AbstractGameObject {

	public GameObject() {

	}

	public GameObject(TextureRegion region) {
		setRegion(region);
	}

	// public void setXPosToCenter() {
	// setX(Constants.GUI_WIDTH / 2 - getWidth() / 2);
	// }

	@Override
	public void updateSize(float width, float height) {
		super.setSize(width / Constants.PIXEL_RATIO_X, height
				/ Constants.PIXEL_RATIO_Y);
	}
}
