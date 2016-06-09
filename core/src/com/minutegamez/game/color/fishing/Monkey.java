package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ImageGameObject;

public class Monkey extends ImageGameObject {

	public static final int STATE_IDLE = 0;
	public static final int STATE_ANGRY = 1;
	public static final int STATE_HAPPY = 2;

	private static final float ANGRY_DURATION = 3.0f;
	private static final float HAPPY_DURATION = 3.0f;

	private Animation animationAngry;
	private Animation animationHappy;
	private Animation animationIdle;

	public float speed;

	private Animation currAnimation;

	private float stateTime;

	public int state;

	public Monkey() {
		Array<AtlasRegion> idleMonkeyRegions = ColorFishingAsset.instance.gameAsset.monkey;
		Array<AtlasRegion> angryMonkeyRegions = ColorFishingAsset.instance.gameAsset.monkeyAngry;
		Array<AtlasRegion> happyMonkeyRegions = ColorFishingAsset.instance.gameAsset.monkeyHappy;

		animationIdle = new Animation(1.0f / 3.0f, idleMonkeyRegions);
		animationAngry = new Animation(1.0f / 2.0f, angryMonkeyRegions);
		animationHappy = new Animation(1.0f / 2.0f, happyMonkeyRegions);

		currAnimation = animationIdle;

		TextureRegion region = idleMonkeyRegions.get(0);
		setRegion(region);
		setPosition(-5, -5);
	}

	@Override
	public void update(float deltaTime) {
		stateTime += deltaTime;

		switch (state) {
		case STATE_HAPPY:
			if (stateTime >= HAPPY_DURATION) {
				setToIdle();
			}
			break;
		case STATE_ANGRY:
			if (stateTime >= HAPPY_DURATION) {
				setToIdle();
			}
			break;
		}
	}

	public void setToHappy() {
		state = STATE_HAPPY;
		currAnimation = animationHappy;
		stateTime = 0;
	}

	public void setToAngry() {
		state = STATE_ANGRY;
		currAnimation = animationAngry;
		stateTime = 0;
	}

	public void setToIdle() {
		state = STATE_IDLE;
		currAnimation = animationIdle;
		stateTime = 0;
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
