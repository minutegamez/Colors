package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.utils.Constants;

public class Fish extends ImageGameObject {

	public float speed;

	private Animation currAnimation;

	private float stateTime;
	public int colorIndex;

	public static final int STATE_SWIMMING = 1;
	public static final int STATE_STOPPED = 2;
	public static final int STATE_NOT_VISIBLE = 3;

	public static final int TYPE_BIG = 1;
	public static final int TYPE_SMALL = 2;
	public static final int TYPE_RAND = 3;

	private Array<Animation> fishAnimation1;
	private Array<Animation> fishAnimation2;

	private ParticleEffect effectBubble;
	public int state;

	public Fish() {

	}

	public Fish(ParticleEffect effect) {
		this.effectBubble = effect;

		fishAnimation1 = ColorFishingAsset.instance.gameAsset.fishAnimation1;
		fishAnimation2 = ColorFishingAsset.instance.gameAsset.fishAnimation2;

		setAnimation(fishAnimation1.get(0));
		state = STATE_NOT_VISIBLE;
		effectBubble.start();
	}

	@Override
	public void update(float deltaTime) {
		if (state == STATE_SWIMMING) {
			stateTime += deltaTime;

			float x = getX() - speed * deltaTime;
			setPosition(x, getY());

			if (x < -getWidth()) {
				state = STATE_NOT_VISIBLE;
				// effectBubble.();
			}

		}
		effectBubble.setPosition(getX() + getWidth() * .9f, getY()
				+ getHeight() / 2);
		effectBubble.update(deltaTime);
	}

	private void setAnimation(Animation animation) {
		currAnimation = animation;
		TextureRegion region = currAnimation.getKeyFrame(0);

		float width = region.getRegionWidth() / Constants.PIXEL_RATIO_X;
		float height = region.getRegionHeight() / Constants.PIXEL_RATIO_Y;

		setSize(width, height);
	}

	public void setType(int type) {
		Array<Animation> fishAnimation = null;
		if (type == TYPE_BIG) {
			fishAnimation = fishAnimation1;
		} else if (type == TYPE_SMALL) {
			fishAnimation = fishAnimation2;
		} else {
			int rand = MathUtils.random(2);
			if (rand == 0) {
				fishAnimation = fishAnimation1;
			} else {
				fishAnimation = fishAnimation2;
			}
		}
		setAnimation(fishAnimation.get(colorIndex));

	}

	public void reset() {
		// set random animation

		// set random scale
		float randScale = MathUtils.random(.9f, 1.0f);
		setScale(randScale, randScale);

		System.out.println(getX());
		effectBubble.setPosition(getX(), getY());
		effectBubble.update(1);
		effectBubble.start();
		// reset getRotation()
		setRotation(0);
		state = STATE_SWIMMING;
	}
	
	public TextureRegion getRegion() {
		return currAnimation.getKeyFrame(stateTime, true);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		effectBubble.draw(batch);
		TextureRegion region = currAnimation.getKeyFrame(stateTime, true);
		batch.draw(region.getTexture(), getX(), getY(), getOriginX(),
				getOriginY(), getWidth(), getHeight(), getScaleX(),
				getScaleY(), getRotation(), region.getRegionX(),
				region.getRegionY(), region.getRegionWidth(),
				region.getRegionHeight(), false, false);
	}
}
