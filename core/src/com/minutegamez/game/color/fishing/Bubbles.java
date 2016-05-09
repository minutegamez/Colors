package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.utils.Constants;

public class Bubbles extends ImageGameObject {

	private static final int MAX_BUBBLE = 5;

	public Array<Bubble> visibleBubblesOnTank;
	private float[] xPos = { 7.1f, 7.4f, 7.7f, 8f, 8.3f };
	// private float[] yPos = { 1, 4, 3, 6, 2 };
	private float[] yPos = { 1.5f, 1.1f, 1.6f, 1.1f, 1.5f };

	public Bubbles(TweenManager tweenManager) {
		visibleBubblesOnTank = new Array<Bubble>();

		for (int j = 0; j < MAX_BUBBLE; j++) {
			visibleBubblesOnTank.add(new Bubble(xPos[j], yPos[j], tweenManager,
					j*.7f));
		}
	}

	public void update(float deltaTime) {
		for (Bubble bubble : visibleBubblesOnTank) {
			bubble.update(deltaTime);

			if (bubble.getY() > Constants.VIEWPORT_HEIGHT - 4)
				bubble.reset();
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (Bubble bubble : visibleBubblesOnTank) {
			bubble.draw(batch, parentAlpha);
		}
	}

	public class Bubble extends ImageGameObject {

		static final int STATE_SPAWNED = 0;
		static final int STATE_NOT_SPAWNED = 1;

		float speed;
		float initialXPos;
		float initialYPos;
		private TweenManager tweenManager;
		float stateTime = 0;
		float delay;
		int state;
		Timeline timeline;

		public Bubble(float x, float y, TweenManager tweenManager, float delay) {
			this.tweenManager = tweenManager;
			this.delay = delay;
			initialXPos = x;
			initialYPos = y;
			setRegion(ColorFishingAsset.instance.gameAsset.bubble, .5f, .5f);
			setPosition(x, y);
			startWigglyEffect();
			state = STATE_NOT_SPAWNED;
		}

		private void startWigglyEffect() {
			setScale(0, 0);

			if (timeline != null) {
				tweenManager.killTarget(this);
			}

			timeline = Timeline
					.createParallel()
					.push(Tween.to(this, ActorAccessor.SCALE_XY, .2f).target(1,
							1))
//					.push(Timeline
//							.createSequence()
//							.push(Tween.to(this, ActorAccessor.POS_X, .1f)
//									.target(getX() + .3f).ease(Linear.INOUT)
//									.repeatYoyo(1, 0))
//							.push(Tween.to(this, ActorAccessor.POS_X, .2f)
//									.target(getX() - .3f).ease(Linear.INOUT)
//									.repeatYoyo(5, 0)).repeat(2, 0).delay(.3f))
					.start(tweenManager);

		}

		@Override
		public void update(float deltaTime) {
			switch (state) {
			case STATE_SPAWNED:
				float y = getY() + deltaTime * 2f;
				setPosition(getX(), y);
				break;
			case STATE_NOT_SPAWNED:
				if (stateTime < delay) {
					stateTime += deltaTime;
				} else {
					state = STATE_SPAWNED;
				}
				break;
			}
		}

		@Override
		public void draw(Batch batch, float parentAlpha) {
			if (state == STATE_SPAWNED) {
				super.draw(batch, parentAlpha);
			}
		}

		public void reset() {
			setPosition(initialXPos, initialYPos);
			speed = 1;
			startWigglyEffect();
		}
	}
}