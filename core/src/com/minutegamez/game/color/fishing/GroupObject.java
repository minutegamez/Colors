package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ImageGameObject;

public class GroupObject extends ImageGameObject {

	private Array<ImageGameObject> objects;

	public GroupObject() {
		objects = new Array<ImageGameObject>();
	}

	public void add(ImageGameObject object) {
		objects.add(object);
	}

	@Override
	public void draw(Batch batch, float parentAlpha){
		for(ImageGameObject object : objects){
			object.draw(batch, 1f);
		}
	}
	
	@Override
	public void update(float delta){
		for(ImageGameObject object : objects){
			object.update(delta);
		}
	}
}
