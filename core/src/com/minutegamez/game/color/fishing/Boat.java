package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.ImageGameObject;

public class Boat extends ImageGameObject {

	private Monkey monkey;
	private TweenManager tweenManager;
	private Flowers flowers;

	public Boat(TweenManager tweenManager) {
		this.tweenManager = tweenManager;
		setRegion(ColorFishingAsset.instance.gameAsset.boat);
		monkey = new Monkey();
		setXPosToCenter();
		setY(6.5f);
		flowers = new Flowers(tweenManager);

		Timeline.createParallel()
				.push(Tween.to(this, ActorAccessor.POS_Y, 3)
						.target(getY() + .2f).repeatYoyo(20, 0))
				.push(Tween.to(this, ActorAccessor.POS_X, 3)
						.target(getX() + .2f).repeatYoyo(20, 0))
				.push(Tween.to(this, ActorAccessor.ROTATION, 3).target(-5)
						.repeatYoyo(20, 0)).start(tweenManager);
	}

	public Monkey getMonkey() {
		return monkey;
	}

	public void setMonkey(Monkey monkey) {
		this.monkey = monkey;
	}

	@Override
	public void update(float deltaTime) {
		monkey.setY(getY() + .6f);
		monkey.setX(getX() - .6f);
		monkey.setRotation(getRotation());
		monkey.update(deltaTime);
		flowers.update(deltaTime);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(region.getTexture(), getX(), getY(), getOriginX(),
				getOriginY(), getWidth(), getHeight(), getScaleX(),
				getScaleY(), getRotation(), region.getRegionX(),
				region.getRegionY(), region.getRegionWidth(),
				region.getRegionHeight(), false, false);
		monkey.draw(batch, parentAlpha);
//		flowers.draw(batch, parentAlpha);
	}

	public void init(int targetFish) {
		flowers.init(targetFish);
	}
}
