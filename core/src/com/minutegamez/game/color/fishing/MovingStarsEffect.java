package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Linear;
import aurelienribon.tweenengine.equations.Quint;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.ImageGameObject;

public class MovingStarsEffect extends ImageGameObject {

	private TweenManager tweenManager;
	public ImageGameObject star;
	private ImageGameObject bubble;
	public boolean isFinished = true;
	private TweenCallback callback;
	private ParticleEffect burstBubbleParticle;
	private Vector2 dest;
	private Timeline timeline;
	private ImageGameObject fish;
	private Observer observer;
	
	public MovingStarsEffect(TweenManager tweenManager) {
		this.tweenManager = tweenManager;
		star = new ImageGameObject(ColorFishingAsset.instance.gameAsset.star);
		burstBubbleParticle = new ParticleEffect(ColorFishingAsset.instance.particleAsset.movingStarsParticle);
		bubble = new ImageGameObject(
				ColorFishingAsset.instance.gameAsset.bubble);
		fish = new ImageGameObject();
		dest = new Vector2();
		callback = new TweenCallback() {
			
			@Override
			public void onEvent(int arg0, BaseTween<?> arg1) {
				isFinished = true;
				observer.update();
			}
		};

	}
	
	private Timeline expandBubble() {
		return Timeline
				.createParallel()
				.push(Tween.to(bubble, ActorAccessor.SCALE_XY, .5f)
						.ease(Linear.INOUT).target(1f, 1f))
				.push(Tween.to(fish, ActorAccessor.SCALE_XY, .5f)
						.repeatYoyo(1, 0).target(1.1f, 1.1f));
	}

	private Timeline deflateBubble() {
		return Timeline
				.createParallel()
				.push(Tween.to(bubble, ActorAccessor.SCALE_XY, 1)
						.ease(Quint.IN).target(0, 0))
				.push(Tween.to(fish, ActorAccessor.SCALE_XY, 1).ease(Quint.IN)
						.target(0, 0));
	}

	private Timeline moveBubble() {
		return Timeline
				.createParallel()
				.push(Tween.to(bubble, ActorAccessor.CPOS_XY, 1).ease(Quint.IN)
						.target(dest.x, dest.y))
				.push(Tween.to(fish, ActorAccessor.CPOS_XY, 1).ease(Quint.IN)
						.target(dest.x, dest.y));
	}

	public void start(Observer observer) {
		this.observer = observer;
		if (timeline != null) {
			timeline.kill();
		}
		bubble.setRotation(0);
		fish.setRotation(0);
		star.setScale(1, 1);
		fish.setScale(1, 1);
		bubble.setScale(0, 0);
		timeline = Timeline
				.createSequence()
				.push(expandBubble())
				.push(Timeline
						.createParallel()
						.delay(1)
						// scale star
						.push(deflateBubble())
						.push(moveBubble())
						.push(Tween.to(bubble, ActorAccessor.ROTATION, 1)
								.target(360))
						// rotate star
						.push(Tween.to(fish, ActorAccessor.ROTATION, 1).target(
								360))).setCallback(callback)
				.start(tweenManager);
		isFinished = false;
		burstBubbleParticle.start();
	}

	@Override
	public void setPosition(float x, float y) {
		star.setPosition(x - star.getWidth() / 2, y - star.getHeight() / 2);
		bubble.setPosition(x - bubble.getWidth() / 2, y - bubble.getHeight()
				/ 2);
		fish.setPosition(x - fish.getWidth() / 2, y - fish.getHeight() / 2);
		burstBubbleParticle.setPosition(x, y);

	}

	public void setDestination(float x, float y) {
		dest.set(x, y);
	}

	public void setFishRegion(TextureRegion region) {
		fish.setRegion(region);
		bubble.setSize(fish.getWidth() * 1.3f, fish.getWidth() * 1.3f);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (!isFinished) {
			fish.draw(batch, parentAlpha);
			bubble.draw(batch, parentAlpha);
			burstBubbleParticle.draw(batch, parentAlpha);
		}
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		burstBubbleParticle.update(delta);
	}

}
