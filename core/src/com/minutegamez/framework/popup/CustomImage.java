package com.minutegamez.framework.popup;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Image that can change color
 */
public class CustomImage extends Image {
	private TextureRegion region;

	public CustomImage(TextureRegion region) {
		super(region);
		this.region = region;
		setSize(region.getRegionWidth(), region.getRegionHeight());
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation());
		batch.setColor(color.r, color.g, color.b, parentAlpha);
	}
}
