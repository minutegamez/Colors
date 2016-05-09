package com.minutegamez.framework;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class ButtonGameObject extends ImageGameObject {
	public boolean isTouched;

	public TextureRegion regionUp;
	public TextureRegion regionDown;

	public boolean flipX = false;

	public ButtonGameObject(TextureRegion regionUp) {
		this.regionDown = regionUp;
		this.regionUp = regionUp;
		setRegion(regionUp);
	}

	@Override
	public void setRegion(TextureRegion region) {
		this.region = region;
	}

	public ButtonGameObject(Array<AtlasRegion> region, float width, float height) {
		regionUp = region.get(0);
		regionDown = region.get(1);
		setRegion(regionUp);
		setSize(width, height);
		setBounds(getX(), getY(), getWidth(), getHeight());
	}

	public ButtonGameObject(TextureRegion regionUp, TextureRegion regionDown) {
		super();

		this.regionUp = regionUp;
		this.regionDown = regionDown;
		setRegion(regionUp);
	}

	public void onFocus() {
		isTouched = true;
		setRegion(regionDown);
	}

	public void lostFocus() {
		isTouched = false;
		setRegion(regionUp);
	}
}
