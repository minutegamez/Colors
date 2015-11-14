package com.minutegamez.framework.popup;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.minutegamez.guiassets.ProfileAssets;
import com.minutegamez.guiassets.UIAssets;

public class Instruction {
	private Label label;
	private Image image;

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Instruction(AtlasRegion atlasRegion, String text) {
		image = new Image(atlasRegion);
		label = new Label(text, UIAssets.uiSkin,
				"default-font", Color.BLACK);
	}
}
