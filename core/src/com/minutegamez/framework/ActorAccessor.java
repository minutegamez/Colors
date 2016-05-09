package com.minutegamez.framework;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorAccessor implements TweenAccessor<Actor> {
	public static final int POS_X = 1;
	public static final int POS_Y = 2;
	public static final int POS_XY = 3;
	public static final int CPOS_XY = 4;
	public static final int SCALE_XY = 5;
	public static final int ROTATION = 6;
	public static final int OPACITY = 7;
	public static final int TINT = 8;

	@Override
	public int getValues(Actor object, int type, float[] values) {
		switch (type) {
		default:
		case POS_X:
			values[0] = object.getX();
			return 1;
		case POS_Y:
			values[0] = object.getY();
			return 1;
		case POS_XY:
			values[0] = object.getX();
			values[1] = object.getY();
			return 2;
		case CPOS_XY:
			values[0] = object.getX() + object.getWidth() / 2.0f;
			values[1] = object.getY() + object.getHeight() / 2.0f;
			return 2;
		case SCALE_XY:
			values[0] = object.getScaleX();
			values[1] = object.getScaleY();
			return 2;
		case ROTATION:
			values[0] = object.getRotation();
			return 1;
		case OPACITY:
			values[0] = object.getColor().a;
			return 1;
		case TINT:
			values[0] = object.getColor().r;
			values[1] = object.getColor().g;
			values[2] = object.getColor().b;
			return 3;
		}
	}

	@Override
	public void setValues(Actor object, int type, float[] values) {
		switch (type) {
		default:
		case POS_X:
			object.setX(values[0]);
			return;
		case POS_Y:
			object.setY(values[0]);
			return;
		case POS_XY:
			object.setPosition(values[0], values[1]);
			System.out.println(values[0]);
			return;
		case CPOS_XY:
			object.setX(values[0] - object.getWidth() / 2.0f);
			object.setY(values[1] - object.getHeight() / 2.0f);
			return;
		case SCALE_XY:
			object.setScale(values[0], values[1]);
			return;
		case ROTATION:
			object.setRotation(values[0]);
			return;
		case OPACITY:
			Color color = object.getColor();
			color.set(color.r, color.g, color.b, values[0]);
			object.setColor(color);
			return;
		case TINT:
			color = object.getColor();
			color.set(values[0], values[1], values[2], color.a);
			object.setColor(color);
		}
	}
}
