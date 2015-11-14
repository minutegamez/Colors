package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.ImageGameObject;

public class Wave extends ImageGameObject {

	private TweenManager tweenManager;
	private float yIncr;
	
	public Wave(TextureRegion region, TweenManager tweenManager, float yIncr) {
		this.yIncr = yIncr;
		this.tweenManager = tweenManager;
		setRegion(region);
		setXPosToCenter();
		setY(6.5f);
	}

	public void startAnimation() {
		Timeline.createParallel()
				.push(Tween.to(this, ActorAccessor.POS_Y, 3)
						.target(getY() + yIncr).repeatYoyo(20, 0))
				.push(Tween.to(this, ActorAccessor.POS_X, 3)
						.target(getX() + yIncr).repeatYoyo(20, 0))
				.start(tweenManager);
	}
}
