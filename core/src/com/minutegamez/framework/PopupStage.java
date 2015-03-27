package com.minutegamez.framework;

import com.badlogic.gdx.scenes.scene2d.Group;

public abstract class PopupStage extends Group {

	public PopupStage() {
	}

	public abstract void show();

	public abstract void hide();

	public abstract int getState();

}
