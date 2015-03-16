package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;

public class GUIAssets extends Assets {

	private Assets splashAssets;
	private Assets profileAssets;
	private Assets backgroundAssets;
	private Assets uiAssets;

	public GUIAssets() {
		super(new AssetManager());
	}

	public void load() {
		splashAssets = new SplashAssets(manager);
		profileAssets = new ProfileAssets(manager);
		backgroundAssets = new BackgroundAssets(manager);
		uiAssets = new UIAssets(manager);
	}

	@Override
	public void dispose() {
		manager.dispose();
		uiAssets.dispose();
	}

	@Override
	public void reload() {
		manager.finishLoading();
	}

	@Override
	public void init() {

	}

}
