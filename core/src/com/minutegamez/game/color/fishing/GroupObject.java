package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.AbstractGameObject;

public class GroupObject extends AbstractGameObject {

	private Array<AbstractGameObject> objects;

	public GroupObject() {
		objects = new Array<AbstractGameObject>();
	}

	public void add(AbstractGameObject object) {
		objects.add(object);
	}

	@Override
	public void render(SpriteBatch batch){
		for(AbstractGameObject object : objects){
			object.render(batch);
		}
	}
}
