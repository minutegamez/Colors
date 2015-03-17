package com.minutegamez.screens.profile.stage.profile;

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
import com.minutegamez.screens.profile.stage.profile.model.Gender;
import com.minutegamez.screens.profile.stage.profile.model.Profile;

public class ProfileButton extends Button {

	private Image image;
	private Label label;

	public ProfileButton(Profile profile) {
		AtlasRegion up = ProfileAssets.btnProfile.get(0);
		AtlasRegion down = ProfileAssets.btnProfile.get(1);

		setStyle(new ButtonStyle(new TextureRegionDrawable(up),
				new TextureRegionDrawable(down), null));
		setBounds(0, 0, up.getRegionWidth(), up.getRegionHeight());
		setTransform(true);
		setOrigin(up.getRegionWidth() / 2, up.getRegionHeight() / 2);
		setScale(0f, 0f);

		initImage(profile.getGender());
		initLabel(profile.getName());
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
