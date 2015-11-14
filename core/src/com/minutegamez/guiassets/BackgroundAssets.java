package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class BackgroundAssets implements Asset {

	private static final String GRASS_BACKGROUND = "images/background/fishing_background.atlas";

	public static final BackgroundAssets instance = new BackgroundAssets();
	public  AtlasRegion grass_background;

	@Override
	public void load(AssetManager manager) {
		manager.load(GRASS_BACKGROUND, TextureAtlas.class);
		manager.finishLoading();
	}

	@Override
	public void init(AssetManager manager) {
		TextureAtlas atlas = manager.get(GRASS_BACKGROUND);
		grass_background = atlas.findRegion("background");
	}

	@Override
	public void reload() {

	}

	@Override
	public void dispose() {

	}

}
