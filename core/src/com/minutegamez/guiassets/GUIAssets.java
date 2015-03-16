package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;

public class GUIAssets extends Assets {

	private Assets splashAssets;
	private Assets profileAssets;
	private Assets backgroundAssets;

	public GUIAssets() {
		super(new AssetManager());
	}

	public void load() {
		splashAssets = new SplashAssets(manager);
		profileAssets = new ProfileAssets(manager);
		backgroundAssets = new BackgroundAssets(manager);
	}

	@Override
	public void dispose() {
		manager.dispose();
	}

	@Override
	public void reload() {
		manager.finishLoading();
	}

	@Override
	public void init() {

	}

}
