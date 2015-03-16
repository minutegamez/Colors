package com.minutegamez.screens.profile.stage.profile;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.minutegamez.guiassets.ProfileAssets;
import com.minutegamez.guiassets.UIAssets;

public class ProfileButton extends Button {

	private Image image;
	private Label label;

	public ProfileButton() {
		AtlasRegion up = ProfileAssets.btnProfile.get(0);
		AtlasRegion down = ProfileAssets.btnProfile.get(1);

		setStyle(new ButtonStyle(new TextureRegionDrawable(up),
				new TextureRegionDrawable(down), null));
		setBounds(0, 0, up.getRegionWidth(), up.getRegionHeight());
		setTransform(true);
		setOrigin(up.getRegionWidth() / 2, up.getRegionHeight() / 2);
		setScale(0f, 0f);

		initImage();
		initLabel("Jaime");
	}

	private void initLabel(String string) {
		Skin skin = UIAssets.uiSkin;
		label = new Label(string, skin, "default.fnt", Color.BLACK);
		addActor(label);
	}

	private void initImage() {
		AtlasRegion region = ProfileAssets.imgFemale;
		image = new Image(new TextureRegionDrawable(region));
		addActor(image);
	}
}
