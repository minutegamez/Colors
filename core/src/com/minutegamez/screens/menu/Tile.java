package com.minutegamez.screens.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.minutegamez.guiassets.MenuAssets;

public class Tile extends Image {

	public Tile(int index) {
		AtlasRegion region = MenuAssets.tiles.get(index);
		if (region == null) {
			Gdx.app.log("test", "test");
		} else {
			Gdx.app.log("test1", "test1");
		}
		setDrawable(new TextureRegionDrawable(region));
		setBounds(0, 0, region.getRegionWidth(), region.getRegionHeight());
		setOrigin(region.getRegionWidth() / 2, region.getRegionHeight() / 2);
	}

}
