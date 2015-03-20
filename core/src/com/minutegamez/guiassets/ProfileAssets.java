package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.PopupAssets;
import com.minutegamez.screens.menu.statpopup.StatAssets;
import com.minutegamez.screens.profile.newuserpopup.NewUserAssets;

public class ProfileAssets implements Assets {

	public static final ProfileAssets instance = new ProfileAssets();
	private static final String TEXTURE = "images/profile/profile.atlas";

	public static Array<AtlasRegion> btnProfile;
	public static AtlasRegion imgMale;
	public static AtlasRegion imgFemale;

	private ProfileAssets() {
	}

	@Override
	public void load(AssetManager manager) {
		manager.load(TEXTURE, TextureAtlas.class);
		manager.finishLoading();
	}

	@Override
	public void init(AssetManager manager) {
		TextureAtlas atlas = manager.get(TEXTURE);
		btnProfile = atlas.findRegions("btnProfile");
		imgMale = atlas.findRegion("boy");
		imgFemale = atlas.findRegion("girl");
		NewUserAssets.instance.init(atlas);
		StatAssets.instance.init(atlas);
	}

	@Override
	public void reload() {

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
}
