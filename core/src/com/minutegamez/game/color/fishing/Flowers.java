package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.game.color.fishing.LevelService.Level;
import com.minutegamez.utils.Constants;

public class Flowers extends ImageGameObject{
	private final int MAX_EMPTY_FLOWERS = 10;

	private int colorIndex;
	private Level level;

	private Array<Flower> emptyFishesList;
	private Array<Flower> emptyFishes;

	private int emptyFishIndex;

	// private Vector2 emptyFishCenterPos;

	private TweenManager manager;

	public Flowers(TweenManager manager) {
		// colorsBatch = new Array<Integer>();
		emptyFishes = new Array<Flower>();
		emptyFishesList = new Array<Flower>();
		// emptyFishCenterPos = new Vector2();
		// colorsToFind = new Array<Integer>();
		this.manager = manager;

		for (int j = 0; j < MAX_EMPTY_FLOWERS; j++) {
			Flower img = new Flower();
			img.setColor(Color.GRAY);
			emptyFishesList.add(img);
		}
	}

	public void reset(int colorIndex) {
		emptyFishIndex = 0;
		this.colorIndex = colorIndex;
		
		//color change to gray here///
	}

//	public Vector2 getEmptyFishPos() {
//		ImageGameObject ImageObject = emptyFishes.get(emptyFishIndex);
//		emptyFishCenterPos.set(ImageObject.getX() + ImageObject.getWidth(),
//				ImageObject.getY() + ImageObject.getHeight());
//		return emptyFishCenterPos;
//	}

	public void nextTarget() {
		emptyFishIndex++;
	}

	public ImageGameObject getEmptyFish() {
		ImageGameObject ImageObject = emptyFishes.get(emptyFishIndex);
		return ImageObject;
	}

	public void init(int targetCount) {

		Color color = Color.GRAY;
		for (ImageGameObject ImageObject : emptyFishes) {
			Tween.to(ImageObject, ActorAccessor.TINT, .5f)
					.target(color.r, color.g, color.b).start(manager);
		}
		emptyFishes.clear();

		ImageGameObject emptyFish = emptyFishesList.get(0);

		float width = emptyFish.getWidth();
		float height = emptyFish.getHeight();

		float x = Constants.VIEWPORT_WIDTH / 2 - (targetCount * width) / 2;
		float y = Constants.VIEWPORT_HEIGHT - height;

		for (int j = 0; j < targetCount; j++) {
			Flower ImageObject = emptyFishesList.get(j);
			ImageObject.setPosition(x, y);
			emptyFishes.add(ImageObject);
			x += width;
		}
		System.out.println(targetCount);
		emptyFishIndex = 0;
	}

	@Override
	public void update(float deltaTime) {
		for (ImageGameObject ImageObject : emptyFishes) {
			ImageObject.update(deltaTime);
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (ImageGameObject ImageObject : emptyFishes) {
			ImageObject.draw(batch, 1);
		}
	}

}
