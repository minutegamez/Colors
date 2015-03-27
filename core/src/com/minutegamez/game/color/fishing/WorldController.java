package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.TweenManager;

import com.minutegamez.framework.AbstractWorldController;

public class WorldController extends AbstractWorldController{

	private Background background;

	public WorldController(TweenManager tweenManager) {
		super(tweenManager);
		background = new Background();

		groupObject.add(background);
	}

	@Override
	public void generateWorld() {

	}

	@Override
	public void update(float deltaTime) {

	}

}
