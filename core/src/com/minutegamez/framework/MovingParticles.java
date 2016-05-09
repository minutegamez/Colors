package com.minutegamez.framework;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public abstract class MovingParticles extends ImageGameObject {

	public TweenManager tweenManager;
	private Array<MovingParticle> movingParticles;
	private int currIndex;

	public MovingParticles(Array<ParticleEffect> movingParticles,
			TweenManager tweenManager) {

		this.movingParticles = new Array<MovingParticle>();
		for (ParticleEffect effect : movingParticles) {
			this.movingParticles.add(new MovingParticle(effect));
		}
		this.tweenManager = tweenManager;
	}

	public void set(float startX, float startY, float destX, float destY) {
		MovingParticle effect = getParticle();
		effect.setPosition(startX, startY);
		effect.setDestination(destX, destY);
	}

	public MovingParticle getParticle() {
		return movingParticles.get(currIndex);
	}

	public void start() {
		MovingParticle effect = getParticle();
		effect.start();
		if (currIndex + 1 < movingParticles.size) {
			currIndex++;
		} else {
			currIndex = 0;
		}
		startMovingAnimation(effect);
	}

	@Override
	public void update(float deltaTime) {
		for (ParticleObject effect : movingParticles) {
			effect.update(deltaTime);
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (ParticleObject effect : movingParticles) {
			effect.draw(batch, parentAlpha);
		}
	}

	public abstract void startMovingAnimation(MovingParticle effect);

	public class MovingParticle extends ParticleObject {
		boolean isAnimationFinished;
		public Vector2 dest;
		ParticleEffect effect;

		public MovingParticle(ParticleEffect effect) {
			super(effect);
			dest = new Vector2();
		}

		public void setDestination(float x, float y) {
			dest.set(x, y);
		}

	}

}
