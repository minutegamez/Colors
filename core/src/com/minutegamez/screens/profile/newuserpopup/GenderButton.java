package com.minutegamez.screens.profile.newuserpopup;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.screens.profile.Gender;

public class GenderButton extends Button {
	public GenderButton(Gender gender) {

		Array<AtlasRegion> regions = null;
		switch (gender) {
		case FEMALE:
			regions = NewUserAssets.btnFemale;
			break;
		case MALE:
			regions = NewUserAssets.btnMale;
			break;
		default:
			break;
		}

		TextureRegion regionUp = regions.get(0);
		TextureRegion regionDown = regions.get(1);

		ButtonStyle style = new ButtonStyle(
				new TextureRegionDrawable(regionUp), new TextureRegionDrawable(
						regionDown), null);
		setStyle(style);
	}
}
