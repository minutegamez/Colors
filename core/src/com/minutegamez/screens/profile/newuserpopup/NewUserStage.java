package com.minutegamez.screens.profile.newuserpopup;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.screens.profile.Gender;

public class NewUserStage extends PopupStage {

	private Actor background;
	private Actor genderButton;

	public NewUserStage(SpriteBatch batch, TweenManager manager) {
		super(batch, manager);
		initActors();
		addActors();
		setDebugAll(true);
		setPositions();
		hide();
	}

	private void setPositions() {
		background.setPosition(getWidth() / 2 - background.getWidth() / 2,
				getHeight() / 2 - background.getHeight() / 2);
	}


	private void initActors() {
		background = new Background();
		genderButton = new GenderButton(Gender.MALE);
	}

	private void addActors() {
		addActor(background);
		addActor(genderButton);
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
