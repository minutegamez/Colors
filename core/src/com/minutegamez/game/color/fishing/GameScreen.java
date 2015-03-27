package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.minutegamez.framework.AbstractGameScreen;
import com.minutegamez.framework.DirectedGame;

public class GameScreen extends AbstractGameScreen {

	public GameScreen(DirectedGame game) {
		super(game);

		worldController = new WorldController(tweenManager);
		worldRenderer = new WorldRenderer(worldController);

	}

	@Override
	public void draw() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render(batch);
	}

	@Override
	public void update(float delta) {
		worldController.update(delta);
	}

	@Override
	public InputProcessor getInputProcessor() {
		return null;
	}

}
