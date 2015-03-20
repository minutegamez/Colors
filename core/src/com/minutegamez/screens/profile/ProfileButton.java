package com.minutegamez.screens.profile;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.minutegamez.guiassets.ProfileAssets;
import com.minutegamez.guiassets.UIAssets;

public class ProfileButton extends Button {

	private Image image;
	private Label label;
	private Profile profile;

	public ProfileButton(Profile profile) {
		this.profile = profile;

		initButton();
		initImage(profile.getGender());
		initLabel(profile.getName());
	}

	// Empty Profile
	public ProfileButton() {
		initButton();
		initImage(Gender.MALE);
		initLabel("Empty");
	}

	private void initButton() {
		setTransform(true);
		AtlasRegion up = ProfileAssets.btnProfile.get(0);
		AtlasRegion down = ProfileAssets.btnProfile.get(1);

		setStyle(new ButtonStyle(new TextureRegionDrawable(up),
				new TextureRegionDrawable(down), null));
		setBounds(0, 0, up.getRegionWidth(), up.getRegionHeight());
		setOrigin(up.getRegionWidth() / 2, up.getRegionHeight() / 2);
		// for tween effect
		setScale(0f, 0f);
	}

	private void initLabel(String string) {
		Skin skin = UIAssets.uiSkin;
		label = new Label(string, skin, "default-font", Color.BLACK);
		label.setAlignment(Align.center);
		label.setWidth(getWidth());
		label.setHeight(getHeight() / 5);
		label.setDebug(true);
		addActor(label);
	}

	private void initImage(Gender gender) {
		AtlasRegion region = null;
		switch (gender) {
		case FEMALE:
			region = ProfileAssets.imgFemale;
			break;
		case MALE:
			region = ProfileAssets.imgMale;
			break;
		default:
			break;
		}

		image = new Image(new TextureRegionDrawable(region));
		addActor(image);
	}
}
