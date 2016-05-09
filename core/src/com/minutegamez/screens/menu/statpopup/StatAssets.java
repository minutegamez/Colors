package com.minutegamez.screens.menu.statpopup;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.PopupAssets;
import com.minutegamez.guiassets.ProfileAssets;

public class StatAssets implements PopupAssets {

	public static final StatAssets instance = new StatAssets();

	private StatAssets() {

	}

	public static AtlasRegion background;

	@Override
	public void init(TextureAtlas atlas) {
		background = atlas.findRegion("score_background");
	}
}
