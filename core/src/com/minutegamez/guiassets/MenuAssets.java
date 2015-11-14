package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class MenuAssets implements Asset {

	public static final MenuAssets instance = new MenuAssets();
	private static final String TEXTURE = "images/menu/screen_colors.pack";

	public static Array<AtlasRegion> tiles;
	public static Array<AtlasRegion> btnStat;

	private MenuAssets() {
	}

	@Override
	public void load(AssetManager manager) {
		manager.load(TEXTURE, TextureAtlas.class);
		manager.finishLoading();
	}

	@Override
	public void init(AssetManager manager) {
		TextureAtlas atlas = manager.get(TEXTURE);
		tiles = atlas.findRegions("tile");
		btnStat = atlas.findRegions("btnBack");
	}

	@Override
	public void reload() {

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
}
