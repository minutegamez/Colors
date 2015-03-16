package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class BackgroundAssets extends Assets {

	private static final String GRASS_BACKGROUND = "images/background/grass_background.pack";

	public static AtlasRegion grass_background;

	public BackgroundAssets(AssetManager manager) {
		super(manager);

	}

	@Override
	public void load() {
		manager.load(GRASS_BACKGROUND, TextureAtlas.class);
		manager.finishLoading();
	}

	@Override
	public void init() {
		TextureAtlas atlas = manager.get(GRASS_BACKGROUND);
		grass_background = atlas.findRegion("background");
	}

}
