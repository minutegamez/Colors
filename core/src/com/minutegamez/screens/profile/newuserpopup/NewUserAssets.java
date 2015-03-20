package com.minutegamez.screens.profile.newuserpopup;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.PopupAssets;
import com.minutegamez.guiassets.ProfileAssets;

public class NewUserAssets implements PopupAssets {

	public static final NewUserAssets instance = new NewUserAssets();

	private NewUserAssets() {

	}

	public static AtlasRegion background;
	public static AtlasRegion textBackground;
	public static Array<AtlasRegion> btnMale;
	public static Array<AtlasRegion> btnFemale;

	@Override
	public void init(TextureAtlas atlas) {
		background = atlas.findRegion("score_popup");
		textBackground = atlas.findRegion("text");
		btnMale = atlas.findRegions("btnMale");
		btnFemale = atlas.findRegions("btnFemale");
	}
}
