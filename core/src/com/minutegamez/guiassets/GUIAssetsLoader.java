package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.popup.PopupAsset;
import com.minutegamez.game.color.fishing.ColorFishingAsset;

public class GUIAssetsLoader {

	private AssetManager manager;
	private Array<Asset> assets;

	public void load() {
		manager = new AssetManager();
		assets = new Array<Asset>();

		loadInitAsset(SplashAssets.instance);
		loadInitAsset(ProfileAssets.instance);
		loadInitAsset(BackgroundAssets.instance);
		loadInitAsset(UIAssets.instance);
		loadInitAsset(MenuAssets.instance);
		// TODO:
		// create own game asset loadder!!
		loadInitAsset(PopupAsset.instance);
		// end of gameloaders temp
	}

	public void loadInitAsset(Asset asset) {
		asset.load(manager);
		asset.init(manager);
		assets.add(asset);
	}

	public void dispose() {
		manager.dispose();
		for (Asset asset : assets) {
			asset.dispose();
		}
	}

	public void reload() {
		manager.finishLoading();
	}
}
