package com.minutegamez.framework;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class AbstractGameObject extends Actor {
	protected TextureRegion region;

	public abstract void updateSize(float width, float height);

	public void setRegion(TextureRegion region) {
		this.region = region;
		updateSize(region.getRegionWidth(), region.getRegionHeight());
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (region != null) {
			batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
					getWidth(), getHeight(), getScaleX(), getScaleY(),
					getRotation());
		}
	}

	public void update(float deltaTime) {

	}
}