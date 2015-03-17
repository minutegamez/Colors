package com.minutegamez.guiassets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class UIAssets implements Assets {

	public static final UIAssets instance = new UIAssets();
	public static Skin uiSkin;


	@Override
	public void load(AssetManager manager) {
		uiSkin = new Skin(Gdx.files.internal("data/uiskin.json"));
	}


	@Override
	public void dispose() {
		uiSkin.dispose();
		Gdx.app.log("", "disposed");
	}


	@Override
	public void init(AssetManager manager) {

	}


	@Override
	public void reload() {

	}

}
