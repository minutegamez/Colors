package com.minutegamez.screens.profile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Interpolation;
import com.minutegamez.framework.DirectedGame;
import com.minutegamez.framework.GUIScreen;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.game.color.fishing.GameScreen;
import com.minutegamez.screens.transition.ScreenTransition;
import com.minutegamez.screens.transition.ScreenTransitionSlide;

public class ProfileScreen extends GUIScreen {

	public static final int POPUP_PROFILE_SELECTION = 100;
	public static final int POPUP_PAUSE = 101;

	private PopupStage profileStage;

	public ProfileScreen(DirectedGame game) {
		super(game);
		initStages();
		setPopup(profileStage);
	}

	private void initStages() {
		profileStage = new ProfileStage(batch, guiTweenManager);
	}

	@Override
	public InputProcessor getInputProcessor() {
		if (currScreen != null) {
			return currScreen;
		}
		return null;
	}

	@Override
	public void resize(int width, int height) {
		if (currScreen != null) {
			currScreen.getViewport().update(width, height);
		}
	}

	@Override
	public void draw() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (currScreen != null) {
			currScreen.draw();
		}
	}

	@Override
	public void update(float delta) {
		guiTweenManager.update(delta);
		if (currScreen != null) {
			if (currScreen == profileStage)
				checkProfileSelectionResponse();
		}
	}

	private void checkProfileSelectionResponse() {
		switch (profileStage.getResponse()) {
		case ProfileStage.RESPONSE_PROFILE_SELECTED:
			ScreenTransition transition = ScreenTransitionSlide.init(.5f,
					ScreenTransitionSlide.UP, true, Interpolation.bounceOut);
			game.setScreen(new GameScreen(game), transition);
			break;
		}
	}

	@Override
	public void dispose() {

	}

}
