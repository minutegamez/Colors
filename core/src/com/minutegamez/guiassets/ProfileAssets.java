package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class ProfileAssets extends Assets {

	private static final String TEXTURE = "images/profile/profile.atlas";

	public static Array<AtlasRegion> btnProfile;
	public static AtlasRegion imgMale;
	public static AtlasRegion imgFemale;

	public ProfileAssets(AssetManager manager) {
		super(manager);
	}

	@Override
	public void load() {
		manager.load(TEXTURE, TextureAtlas.class);
		manager.finishLoading();
	}

	@Override
	public void init() {
		TextureAtlas atlas = manager.get(TEXTURE);
		btnProfile = atlas.findRegions("btnProfile");
		imgMale = atlas.findRegion("boy");
		imgFemale = atlas.findRegion("girl");
	}

}
