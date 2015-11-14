package com.minutegamez.framework;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ParticleObject extends Actor {
	private ParticleEffect effect;
	private TweenCallback animationCallback;
	private boolean isAnimationFinished;

	public ParticleObject(ParticleEffect effect) {
		this.effect = effect;
		isAnimationFinished = true;
	}

//	@Override
//	public void setPosition(float x, float y) {
//		setX(x);
//		setY(y);
//	}

	
	public ParticleEffect getParticle(){
		return effect;
	}
	public void update(float delta) {
		effect.setPosition(getX(), getY());
		effect.update(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		effect.draw(batch);
	}

	public void start() {
		effect.start();
		isAnimationFinished = false;
	}

	public TweenCallback getAnimationCallback() {
		return animationCallback;
	}

	class AnimationCallback implements TweenCallback {
		@Override
		public void onEvent(int arg0, BaseTween<?> arg1) {
			isAnimationFinished = true;
			System.out.println("finished");
		}
	}
}