package com.minutegamez.guiassets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class UIAssets extends Assets {

	public static Skin uiSkin;

	public UIAssets(AssetManager manager) {
		super(manager);
		uiSkin = new Skin(Gdx.files.internal("data/uiskin.json"));
	}

	@Override
	public void load() {

	}

	@Override
	public void init() {

	}

	@Override
	public void dispose() {
		uiSkin.dispose();
		Gdx.app.log("", "disposed");
	}

}
