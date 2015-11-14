package com.minutegamez.framework;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.minutegamez.utils.Constants;

public class ImageGameObject extends Actor {

	protected TextureRegion region;

	public ImageGameObject() {

	}

	public ImageGameObject(TextureRegion region) {
		setRegion(region);
	}

	public void setXPosToCenter() {
		setX(Constants.VIEWPORT_WIDTH / 2 - getWidth() / 2);
	}

	public void setRegion(TextureRegion region) {

		this.region = region;

		float width = region.getRegionWidth() / Constants.PIXEL_RATIO_X;
		float height = region.getRegionHeight() / Constants.PIXEL_RATIO_Y;

		setSize(width, height);
	}

	@Override
	public void setSize(float width, float height) {
		super.setSize(width, height);
		setOrigin(Align.center);
	}

	public void setRegion(TextureRegion region, float width, float height) {

		this.region = region;
		setSize(width, height);
	}

	public void update(float deltaTime) {

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (region != null) {
			Color color = getColor();
			batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

			batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
					getWidth(), getHeight(), getScaleX(), getScaleY(),
					getRotation());
			batch.setColor(color.r, color.g, color.b, 1f);
		}
	}
}
