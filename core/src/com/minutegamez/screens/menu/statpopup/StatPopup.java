package com.minutegamez.screens.menu.statpopup;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.screens.profile.Gender;
import com.minutegamez.utils.Constants;

public class StatPopup extends PopupStage {

	private Actor background;

	public StatPopup() {
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
	}

	private void addActors() {
		addActor(background);
	}

	@Override
	public void show() {
		setVisible(true);
	}

	@Override
	public void hide() {
		setVisible(false);
	}

}
