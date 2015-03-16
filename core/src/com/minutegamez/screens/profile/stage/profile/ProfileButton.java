package com.minutegamez.screens.profile.stage.profile;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.minutegamez.guiassets.ProfileAssets;

public class ProfileButton extends Button {

	private Image image;

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
	}

	private void initImage() {
		AtlasRegion region = ProfileAssets.imgFemale;
		image = new Image(new TextureRegionDrawable(region));
		addActor(image);
	}
}
