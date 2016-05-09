package com.minutegamez.framework;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GUIScreen extends AbstractScreen {


	protected TweenManager guiTweenManager;
	protected int currPopupID;

	public GUIScreen(DirectedGame game) {
		super(game);
		batch = new SpriteBatch();
		guiTweenManager = new TweenManager();
	}


	public abstract void resize(int width, int height);


	public abstract void dispose();

	public abstract void draw();

	public abstract void update(float delta);

	public abstract InputProcessor getInputProcessor();

}
