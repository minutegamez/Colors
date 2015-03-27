package com.minutegamez.screens.profile.newuserpopup;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.screens.profile.Gender;
import com.minutegamez.utils.Constants;

public class NewUserStage extends PopupStage {

	private Actor background;
	private Actor genderButton;

	public NewUserStage() {
		setSize(Constants.GUI_WIDTH, Constants.GUI_HEIGHT);
		initActors();
		addActors();
		setDebug(true);
		setPositions();
		hide();
	}

	private void setPositions() {
		background.setPosition(getWidth() / 2 - background.getWidth() / 2,
				getHeight() / 2 - background.getHeight() / 2);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
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
		setVisible(true);
	}

	@Override
	public void hide() {
		setVisible(false);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

}
