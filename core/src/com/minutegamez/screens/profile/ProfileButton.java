package com.minutegamez.screens.profile;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.minutegamez.guiassets.UIAssets;

public class ProfileButton extends Button {

	private Image imgGender;
	private Label label;
	private Skin skin;
	private Profile profile = null;

	public ProfileButton(Skin skin) {
		super(skin, "profile");
		this.skin = skin;

		initGameObjects();
		addActor(label);
		addActor(imgGender);
	}

	private void initGameObjects() {
		imgGender = new Image();

		Skin skin = UIAssets.uiSkin;
		label = new Label("Empty", skin, "default-font", Color.BLACK);
		label.setAlignment(Align.center);
		label.setWidth(getWidth());
		label.setHeight(getHeight() / 5);
	}

	public void init(Profile profile) {
		setProfile(profile);
		initImage(profile.getGender());
		initLabel(profile.getName());
		System.out.println("x");
	}

	private void initLabel(String string) {
		label.setText(string);
	}

	private void initImage(Gender gender) {
		Drawable drawable = null;
		switch (gender) {
		case FEMALE:
			drawable = skin.getDrawable("girl");
			break;
		case MALE:
			drawable = skin.getDrawable("boy");
			break;
		}
		imgGender.setDrawable(drawable);
		imgGender.setSize(drawable.getMinWidth(), drawable.getMinHeight());
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isClicked(Actor actor) {
		if (actor.equals(imgGender)) {
			return true;
		} else if (actor.equals(this)) {
			return true;
		}
		return false;
	}
}
