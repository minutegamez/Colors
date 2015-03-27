package com.minutegamez.framework;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.math.Vector3;
import com.minutegamez.game.color.fishing.GroupObject;

public abstract class AbstractWorldController {

	protected TweenManager tweenManager;
	protected GroupObject groupObject;

	public AbstractWorldController(TweenManager tweenManager) {
		this.tweenManager = tweenManager;
		setObjectGroup(new GroupObject());
	}

	public abstract void generateWorld();

	public abstract void update(float delta);

	public void touchUp(Vector3 touchPoint) {

	}

	public void touchDown(Vector3 touchPoint) {

	}

	public void touchDragged(Vector3 touchPoint) {

	}

	public GroupObject getObjectGroup() {
		return groupObject;
	}

	public void setObjectGroup(GroupObject objectGroup) {
		this.groupObject = objectGroup;
	}

}
