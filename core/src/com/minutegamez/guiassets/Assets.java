package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;

public abstract class Assets {

	protected AssetManager manager;

	public Assets(AssetManager manager) {
		this.manager = manager;
		load();
		init();
	}

	public abstract void load();

	public abstract void init();

	public void reload() {

	}

	public void dispose() {

	}

}
