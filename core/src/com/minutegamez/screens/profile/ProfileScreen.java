package com.minutegamez.screens.profile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.minutegamez.framework.DirectedGame;
import com.minutegamez.framework.GUIScreen;
import com.minutegamez.screens.profile.stage.profile.ProfileStage;
import com.minutegamez.utils.Constants;

public class ProfileScreen extends GUIScreen {

	private ProfileStage profileStage;
	private State state;

	private enum State {
		PAUSED, RESUMED
	}

	public ProfileScreen(DirectedGame game) {
		super(game);
		initStages();
		setState(State.PAUSED);
	}

	private void initStages() {
		profileStage = new ProfileStage(new StretchViewport(
				Constants.GUI_WIDTH, Constants.GUI_HEIGHT), batch);
	}

	@Override
	public void render(float delta) {
		update(delta);
		draw();
	}

	@Override
	public InputProcessor getInputProcessor() {
		return null;
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {
		Gdx.input.setInputProcessor(profileStage);
		profileStage.startAnimation();
	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void draw() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		profileStage.draw();
	}

	@Override
	public void update(float delta) {
		profileStage.act(delta);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
