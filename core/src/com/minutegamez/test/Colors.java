package com.minutegamez.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.minutegamez.utils.Constants;

public class Colors extends ApplicationAdapter {

	private Stage stage;
	private Skin skin;

	@Override
	public void create() {
		stage = new Stage(new StretchViewport(Constants.GUI_WIDTH,
				Constants.GUI_HEIGHT));
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));

		Label label = new Label("Eow", skin, "default-font", Color.BLACK);
		label.scaleBy(100);
		stage.addActor(label);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
}
