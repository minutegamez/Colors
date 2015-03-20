package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;

public class GUIAssetsLoader {

	private AssetManager manager;

	public void load() {
		manager = new AssetManager();

		loadInitAsset(SplashAssets.instance);
		loadInitAsset(ProfileAssets.instance);
		loadInitAsset(BackgroundAssets.instance);
		loadInitAsset(UIAssets.instance);
		loadInitAsset(MenuAssets.instance);
	}

	public void loadInitAsset(Assets asset) {
		asset.load(manager);
		asset.init(manager);
	}

	public void dispose() {
		manager.dispose();
		UIAssets.instance.dispose();
	}

	public void reload() {
		manager.finishLoading();
	}
}
