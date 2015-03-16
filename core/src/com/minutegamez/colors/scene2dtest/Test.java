package com.minutegamez.colors.scene2dtest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.minutegamez.framework.DirectedGame;
import com.minutegamez.utils.Constants;

public class Test implements Screen {

	private Stage stage;

	public Test(DirectedGame game){

	}

	@Override
	public void show() {
		stage = new Stage(new StretchViewport(Constants.GUI_WIDTH,
				Constants.GUI_HEIGHT));
		stage.addActor(new MyActor());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
	    stage.dispose();
	}

}
