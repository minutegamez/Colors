package com.minutegamez.guiassets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ProfileAssets implements Asset {

	public static final ProfileAssets instance = new ProfileAssets();
	private static final String SKIN_PROFILE = "images/profile/profile.json";
	private static final String SKIN_NEW_PROFILE = "images/profile/new_profile.json";
	
	public Skin profileSkin;
	public Skin newProfileSkin;

	private ProfileAssets() {
	}

	@Override
	public void load(AssetManager manager) {
		profileSkin = new Skin(Gdx.files.internal(SKIN_PROFILE));
		newProfileSkin = new Skin(Gdx.files.internal(SKIN_NEW_PROFILE));
	}

	@Override
	public void init(AssetManager manager) {
	}

	@Override
	public void reload() {

	}

	@Override
	public void dispose() {
		profileSkin.dispose();
		newProfileSkin.dispose();
		System.out.println("profi disp");
	}
}
