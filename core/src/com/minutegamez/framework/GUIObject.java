package com.minutegamez.framework;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GUIObject extends AbstractGameObject {

	public GUIObject(TextureRegion region) {
		setRegion(region);
	}

	// public void setXPosToCenter() {
	// setX(Constants.GUI_WIDTH / 2 - getWidth() / 2);
	// }

	@Override
	public void updateSize(float width, float height) {
		super.setSize(width, height);
	}
}
