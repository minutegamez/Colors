package com.minutegamez.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ImageGameObject extends GameObject {

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
		batch.setColor(color);
		batch.draw(region.getTexture(), position.x, position.y,
				origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
				rotation, region.getRegionX(),
				region.getRegionY(), region.getRegionWidth(),
				region.getRegionHeight(), flipX, flipY);
		batch.setColor(1, 1, 1, 1);
	}

}
