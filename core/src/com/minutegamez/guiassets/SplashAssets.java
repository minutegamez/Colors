package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class SplashAssets extends Assets implements AssetErrorListener {

	private static final String TEXTURE_SPLASH = "images/splash/splash.atlas";
	private static final String TEXTURE_SPLASH2 = "images/splash/menu.pack";

	public static AtlasRegion libgdx_logo;
	public static AtlasRegion ubuntu_logo;

	public static AtlasRegion background;
	public static AtlasRegion colorsLabel;
	public static AtlasRegion forKidsLabel;


	public SplashAssets(AssetManager manager) {
		super(manager);
	}

	@Override
	public void load() {
		manager.load(TEXTURE_SPLASH, TextureAtlas.class);
		manager.load(TEXTURE_SPLASH2, TextureAtlas.class);
		manager.finishLoading();
	}

	@Override
	public void init() {
		TextureAtlas atlas = manager.get(TEXTURE_SPLASH);
		libgdx_logo = atlas.findRegion("images");
		ubuntu_logo = atlas.findRegion("logo");

		atlas = manager.get(TEXTURE_SPLASH2);
		background = atlas.findRegion("background");
		colorsLabel = atlas.findRegion("label");
		forKidsLabel = atlas.findRegion("label2");
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {

	}
}
