package com.minutegamez.framework;


import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.Color;
import com.minutegamez.test.GameObject;

public class ObjectAccessor implements TweenAccessor<GameObject> {
	public static final int CPOS_XY = 4;
	public static final int OPACITY = 7;
	public static final int POS_X = 1;
	public static final int POS_XY = 3;
	public static final int POS_Y = 2;
	public static final int ROTATION = 6;
	public static final int SCALE_XY = 5;
	public static final int TINT = 8;

	@Override
	public int getValues(GameObject object, int type, float[] values) {
		switch (type) {
		default:
		case 1:
			values[0] = object.position.x;
			return 1;
		case 2:
			values[0] = object.position.y;
			return 1;
		case 3:
			values[0] = object.position.x;
			values[1] = object.position.y;
			return 2;
		case 4:
			values[0] = object.position.x + object.dimension.x / 2.0f;
			values[1] = object.position.y + object.dimension.y / 2.0f;
			return 2;
		case 5:
			values[0] = object.scale.x;
			values[1] = object.scale.y;
			return 2;
		case 6:
			values[0] = object.rotation;
			return 1;
		case 7:
			values[0] = object.color.a;
			return 1;
		case 8:
			values[0] = object.color.r;
			values[1] = object.color.g;
			values[2] = object.color.b;
			return 3;
		}
	}

	@Override
	public void setValues(GameObject object, int type, float[] values) {
		switch (type) {
		default:
		case 1:
			object.position.x = values[0];
			return;
		case 2:
			object.position.y = values[0];
			return;
		case 3:
			object.position.set(values[0], values[1]);
			return;
		case 4:
			object.position.x = values[0] - object.dimension.x / 2.0f;
			object.position.y = values[1] - object.dimension.y / 2.0f;
			return;
		case 5:
			object.scale.set(values[0], values[1]);
			return;
		case 6:
			object.rotation = values[0];
			return;
		case 7:
			Color color = object.color;
			color.set(color.r, color.g, color.b, values[0]);
			object.color = color;
			return;
		case 8:
			color = object.color;
			color.set(values[0], values[1], values[2], color.a);
			object.color = color;
		}
	}
}
