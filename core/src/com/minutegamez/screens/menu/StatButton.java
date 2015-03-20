package com.minutegamez.screens.menu;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.minutegamez.guiassets.MenuAssets;

public class StatButton extends Button {
	public StatButton() {
		TextureRegion up = MenuAssets.btnStat.get(0);
		TextureRegion down = MenuAssets.btnStat.get(1);
		ButtonStyle style = new ButtonStyle(new TextureRegionDrawable(up),
				new TextureRegionDrawable(down), null);
		setStyle(style);
		setBounds(0, 0, up.getRegionWidth(), up.getRegionHeight());
		setOrigin(up.getRegionWidth() / 2, up.getRegionHeight() / 2);
	}
}
