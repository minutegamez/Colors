package com.minutegamez.framework.popup;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.screens.profile.LevelRating;
import com.minutegamez.screens.profile.Profile;
import com.minutegamez.screens.profile.GameService;
import com.minutegamez.utils.Constants;

public class LevelStage extends PopupStage {

	public static final int RESPONSE_LEVEL_SELECTED = 100;

	private Skin skin;
	private Array<LevelButton> btnLevels;
	private int selectedLevel = 0;
	private int gameIndex;

	private Table table;

	public LevelStage(Batch batch, TweenManager manager, int gameIndex) {
		super(batch, manager);
		skin = PopupAsset.instance.levelSkin;
		listener = new ButtonListener();
		this.gameIndex = gameIndex;

		initGameObjects();
		setSizes();
		setPositions();
		addListeners();

		addActor(table);
		// setDebugAll(true);
	}

	private void addListeners() {
		for (Button button : btnLevels) {
			button.addListener(listener);
		}
	}

	private void initGameObjects() {
		table = new Table();
		table.setTransform(true);

		btnLevels = new Array<LevelButton>();

		for (int j = 0; j < Constants.MAX_LEVEL; j++) {
			// "j+1" because in the json file the index starts from 1
			LevelButton button = new LevelButton(skin, j + 1);
			btnLevels.add(button);
		}

		Drawable background = skin.getDrawable("background");
		table.setBackground(background);
		table.setSize(background.getMinWidth(), background.getMinHeight());
		initLevels();
	}

	private void initLevels() {

		Profile profile = GameService.instance.getSelectedProfile();

		Array<LevelRating> lvlRatings = profile.getGameRatings().get(gameIndex)
				.getLevelRatings();

		for (int j = selectedLevel; j < lvlRatings.size; j++) {
			LevelRating lvlRating = lvlRatings.get(j);

			if (!lvlRating.isLocked()) {
				LevelButton btnLevel = btnLevels.get(j);
				btnLevel.unlock(lvlRating);
			} else {
				// stop loop if a levelbutton is locked
				break;
			}
		}

	}

	private void setPositions() {
		Constants.setPosToCenter(table);

		for (int j = 0; j < Constants.MAX_LEVEL; j++) {
			Button button = btnLevels.get(j);
			table.add(button);
			if ((j + 1) % 3 == 0) {
				table.row();
			}
		}
	}

	private void setSizes() {
		Constants.setOriginToCenter(table);
	}

	class ButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			if (getState() == STATE_ANIMATION_FINISHED) {
				for (int j = 0; j < btnLevels.size; j++) {
					LevelButton button = btnLevels.get(j);
					if (button.isClicked(event.getTarget())) {
						setSelectedLevel(j);
						setResponse(RESPONSE_LEVEL_SELECTED);
						break;
					}
				}
			}
			super.clicked(event, x, y);
		}
	}

	@Override
	public void setResponse(int response) {
		this.response = response;
		switch (getResponse()) {
		case RESPONSE_LEVEL_SELECTED:
			hide();
			break;
		}
	}

	@Override
	public void showEntranceAnimation() {
		table.setScale(.5f, .5f);
		Tween.to(table, ActorAccessor.SCALE_XY, .5f).target(1f, 1f)
				.ease(Back.OUT).setCallback(animationCallback).start(manager);
	}

	@Override
	public void showExitAnimation() {
		Tween.to(table, ActorAccessor.SCALE_XY, .5f).target(0f, 0f)
				.ease(Back.IN).setCallback(animationCallback).start(manager);
	}

	public int getSelectedLevel() {
		return selectedLevel;
	}

	public void setSelectedLevel(int selectedLevel) {
		this.selectedLevel = selectedLevel;
		GameService.instance.setSelectedLevelIndex(selectedLevel);
	}

}
