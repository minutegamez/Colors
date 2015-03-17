package com.minutegamez.guiassets;

import com.badlogic.gdx.assets.AssetManager;


public interface Assets {

	public abstract void load(AssetManager manager);

	public abstract void init(AssetManager manager);

	public void reload();

	public void dispose();

}
