package com.minutegamez.animationtest;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ImageGameObject;

public class Monkey extends ImageGameObject {

	public float speed;

	private Animation currAnimation;

	private float stateTime;

	public int state;

	public Monkey(Array<AtlasRegion> regions) {
		currAnimation = new Animation(1.0f /6.0f, regions);
		TextureRegion region =regions.get(0);
		setRegion(region, region.getRegionWidth(), region.getRegionHeight());
		setPosition(0, 0);
	}

	@Override
	public void update(float deltaTime) {
		stateTime += deltaTime;
	}

	public TextureRegion getRegion() {
		return currAnimation.getKeyFrame(stateTime, true);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		TextureRegion region = currAnimation.getKeyFrame(stateTime, true);
		batch.draw(region.getTexture(), getX(), getY(), getOriginX(),
				getOriginY(), getWidth(), getHeight(), getScaleX(),
				getScaleY(), getRotation(), region.getRegionX(),
				region.getRegionY(), region.getRegionWidth(),
				region.getRegionHeight(), false, false);
	}
}
