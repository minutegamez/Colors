package com.minutegamez.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.framework.AbstractGameObject;

public class ImageGameObject extends AbstractGameObject {

	public TextureRegion getRegion() {
		return region;
	}

	public void setRegion(TextureRegion region) {
		this.region = region;
	}

	private TextureRegion region;

	public ImageGameObject() {

	}

	public void update(float deltaTime) {

	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setColor(getColor());
		batch.draw(region.getTexture(), getX(), getY(),
				getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation(), region.getRegionX(),
				region.getRegionY(), region.getRegionWidth(),
				region.getRegionHeight(), isFlipX(), isFlipY());
		batch.setColor(1, 1, 1, 1);
	}

}
