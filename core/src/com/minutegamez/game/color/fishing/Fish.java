package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.TweenManager;

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
	public static final int STATE_ON_CORRECT_ANIM = 4;

	public static final int STATE_ON_EXIT = 5;
	public static final int STATE_EXITED = 6;

	public static final int TYPE_BIG = 1;
	public static final int TYPE_SMALL = 2;
	public static final int TYPE_RAND = 3;

	private Array<Animation> fishAnimation1;
	private Array<Animation> fishAnimation2;

	private MovingStarsEffect onCaughtAnim;

	private ParticleEffect effectBubble;
	private int state;

	public Fish() {
	}

	class FishAnimationObserver implements Observer {

		@Override
		public void update() {
			setState(STATE_EXITED);
		}

	}

	private FishAnimationObserver observer;

	public Fish(ParticleEffect effect, TweenManager tweenManager) {
		this.effectBubble = effect;
		observer = new FishAnimationObserver();

		fishAnimation1 = ColorFishingAsset.instance.gameAsset.fishAnimation1;
		fishAnimation2 = ColorFishingAsset.instance.gameAsset.fishAnimation2;

		onCaughtAnim = new MovingStarsEffect(tweenManager);

		setAnimation(fishAnimation1.get(0));
		setState(STATE_EXITED);
		effectBubble.start();
	}

	public void init() {

	}

	public void startOnCaughtAnim(float destX, float destY) {
		onCaughtAnim.setFishRegion(getRegion());
		onCaughtAnim.setPosition(getX() + getWidth() / 2, getY() + getHeight()
				/ 2);
		onCaughtAnim.setDestination(destX, destY);
		setState(STATE_ON_CORRECT_ANIM);
		onCaughtAnim.start(getObserver());
	}

	@Override
	public void update(float deltaTime) {
		
		if (state == STATE_SWIMMING) {
			stateTime += deltaTime;

			float x = getX() - speed * deltaTime;
			setPosition(x, getY());

			if (x < -getWidth()) {
				state = STATE_EXITED;
				// effectBubble.();
			}

		}
		effectBubble.setPosition(getX() + getWidth() * .9f, getY()
				+ getHeight() / 2);
		effectBubble.update(deltaTime);
		onCaughtAnim.update(deltaTime);
	}

	private void setAnimation(Animation animation) {
		currAnimation = animation;
		TextureRegion region = currAnimation.getKeyFrame(0);

		float width = region.getRegionWidth() / Constants.PIXEL_RATIO_X;
		float height = region.getRegionHeight() / Constants.PIXEL_RATIO_Y;

		setSize(width, height);
	}

	public int getState() {
		return state;
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

	public void setState(int state) {
		this.state = state;
		switch (state) {
		case STATE_SWIMMING:
			setVisible(true);
			break;
		case STATE_ON_CORRECT_ANIM:
			setVisible(false);
			break;
		}
	}

	public void reset() {
		// set random animation

		// set random scale
		float randScale = MathUtils.random(.9f, 1.0f);
		setScale(randScale, randScale);

		effectBubble.setPosition(getX(), getY());
		effectBubble.update(1);
		effectBubble.start();
		// reset getRotation()
		setRotation(0);
		setState(STATE_SWIMMING);
	}

	public TextureRegion getRegion() {
		return currAnimation.getKeyFrame(stateTime, true);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (isVisible()) {
			effectBubble.draw(batch);
			TextureRegion region = currAnimation.getKeyFrame(stateTime, true);
			batch.draw(region.getTexture(), getX(), getY(), getOriginX(),
					getOriginY(), getWidth(), getHeight(), getScaleX(),
					getScaleY(), getRotation(), region.getRegionX(),
					region.getRegionY(), region.getRegionWidth(),
					region.getRegionHeight(), false, false);
		}
			onCaughtAnim.draw(batch, parentAlpha);
	}

	public FishAnimationObserver getObserver() {
		return observer;
	}

	public void setObserver(FishAnimationObserver observer) {
		this.observer = observer;
	}
}
