package com.minutegamez.framework.popup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.minutegamez.guiassets.Asset;
import com.minutegamez.guiassets.BackgroundAssets;

public class PopupAsset implements Asset {
	private static final String SKIN_PAUSE = "images/popup/pause/popup_pause.json";
	private static final String SKIN_RUNNING = "images/popup/running/popup_running.json";
	private static final String SKIN_READY = "images/popup/ready/popup_ready.json";
	private static final String SKIN_LEVEL = "images/popup/level/popup_level.json";
	private static final String SKIN_TUTORIAL = "images/popup/tutorial/popup_tutorial.json";
	private static final String SKIN_LEVEL_END = "images/popup/level_end/popup_level_end.json";
	private static final String SKIN_TUTORIAL_FISHING = "images/popup/tutorial/tutorial_fishing.json";

	public static final PopupAsset instance = new PopupAsset();

	public Skin pauseSkin;
	public Skin runningSkin;
	public Skin readySkin;
	public Skin levelSkin;
	public Skin tutorialSkin;
	public Skin levelEndSkin;

	// tutorial skins

	public Skin tutorialFishingSkin;

	@Override
	public void load(AssetManager manager) {
		pauseSkin = new Skin(Gdx.files.internal(SKIN_PAUSE));
		runningSkin = new Skin(Gdx.files.internal(SKIN_RUNNING));
		readySkin = new Skin(Gdx.files.internal(SKIN_READY));
		levelSkin = new Skin(Gdx.files.internal(SKIN_LEVEL));
		tutorialSkin = new Skin(Gdx.files.internal(SKIN_TUTORIAL));
		levelEndSkin = new Skin(Gdx.files.internal(SKIN_LEVEL_END));
		tutorialFishingSkin = new Skin(
				Gdx.files.internal(SKIN_TUTORIAL_FISHING));
	}

	@Override
	public void init(AssetManager manager) {
	}

	@Override
	public void reload() {

	}

	@Override
	public void dispose() {
		pauseSkin.dispose();
		runningSkin.dispose();
		readySkin.dispose();
		levelSkin.dispose();
		tutorialSkin.dispose();
		levelEndSkin.dispose();
		tutorialFishingSkin.dispose();
	}
}
