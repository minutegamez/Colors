package com.minutegamez.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class Constants {

	public final static float GUI_WIDTH = 800.0f;
	public final static float GUI_HEIGHT = 480.0f;

	public static final boolean DEBUG_MODE = true;
	public static final int MAX_TILES = 5;
	public static final float VIEWPORT_HEIGHT = 10.0f;
	public static final float VIEWPORT_WIDTH = 15.0f;
	public static final int MAX_COLOR = 7;

	// Ratios
	public static final float PIXEL_RATIO_X = GUI_WIDTH / VIEWPORT_WIDTH;
	public static final float PIXEL_RATIO_Y = GUI_HEIGHT / VIEWPORT_HEIGHT;
	public static final int MAX_LEVEL = 9;
	public static final int MAX_GAME = 5;
	public static int MAX_PROFILE = 6;

	public static final void setPosToCenter(Actor actor) {
		actor.setPosition(Constants.GUI_WIDTH / 2 - actor.getWidth() / 2,
				Constants.GUI_HEIGHT / 2 - actor.getHeight() / 2);
	}

	public static final void setXPosToCenter(Actor actor) {
		actor.setX(Constants.GUI_WIDTH / 2 - actor.getWidth() / 2);
	}

	public static void setOriginToCenter(Actor actor) {
		actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
	}

}
