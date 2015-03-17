package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class ProfileAssets implements Assets {

	public static final ProfileAssets instance = new ProfileAssets();
	private static final String TEXTURE = "images/profile/profile.atlas";

	public static Array<AtlasRegion> btnProfile;
	public static AtlasRegion imgMale;
	public static AtlasRegion imgFemale;

	public ProfileAssets() {
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
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
