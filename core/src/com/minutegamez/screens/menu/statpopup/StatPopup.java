package com.minutegamez.screens.menu.statpopup;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.minutegamez.framework.PopupStage;

public class StatPopup extends PopupStage {

	private Actor background;

	public StatPopup(SpriteBatch batch, TweenManager manager) {
		super(batch, manager);
		initActors();
		addActors();
		setPositions();
		hide();
	}

	private void setPositions() {
		background.setPosition(getWidth() / 2 - background.getWidth() / 2,
				getHeight() / 2 - background.getHeight() / 2);
	}

	private void initActors() {
		background = new Background();
	}

	private void addActors() {
		addActor(background);
	}

	@Override
	public void show() {
//		setVisible(true);
	}

	@Override
	public void hide() {
//		setVisible(false);
	}

	@Override
	public void showEntranceAnimation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showExitAnimation() {
		// TODO Auto-generated method stub
		
	}

}
