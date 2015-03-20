package com.minutegamez.screens.profile;

import static com.badlogic.gdx.math.Interpolation.bounceOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.scaleTo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.minutegamez.screens.profile.newuserpopup.NewUserStage;
import com.minutegamez.utils.Constants;

public class ProfileStage extends Stage {

	private static final float BUTTON_COUNT_X = 3;
	private static final int MAX_VISIBLE_BUTTON = 6;

	private Actor background;
	private Array<ProfileButton> profileButton;

	private NewUserStage newUserStage;
	private ProfileButtonListener profileButtonListener;

	public ProfileStage(StretchViewport stretchViewport, SpriteBatch batch) {
		super(stretchViewport, batch);

		profileButtonListener = new ProfileButtonListener();
		initStages();
		initActors();
		addActors();
		setPosition();

	}

	private void initStages() {
		newUserStage = new NewUserStage();
	}

	private void addActors() {
		addActor(background);

		for (Actor actor : profileButton) {
			addActor(actor);
		}

		addActor(newUserStage);
	}

	private void setPosition() {
		// equal divide
		// float offsetWidth = Constants.GUI_WIDTH / BUTTON_COUNT_X;
		// float posX = (offsetWidth / 2) - profileButton.get(0).getWidth() / 2;

		float btnWidth = profileButton.get(0).getWidth();
		float btnHeight = profileButton.get(0).getHeight();

		float centerX = Constants.GUI_WIDTH / 2;
		float centerY = Constants.GUI_HEIGHT / 2;

		float gapX = 20.0f;
		float gapY = 5.0f;

		float posX = centerX - btnWidth / 2 - gapX - btnWidth;
		float posY = centerY + gapY;

		for (int j = 0; j < MAX_VISIBLE_BUTTON; j++) {
			Actor actor = profileButton.get(j);

			actor.setPosition(posX, posY);
			posX += gapX + btnWidth;

			if (j + 1 == BUTTON_COUNT_X) {
				posX = centerX - btnWidth / 2 - gapX - btnWidth;
				posY = centerY - gapY - btnHeight;
			}

		}
	}

	public void startAnimation() {
		for (Actor actor : profileButton) {
			actor.addAction(parallel(scaleTo(1, 1, .3f, bounceOut)));
		}
	}

	private void initActors() {
		background = new Background();

		int profileCount = 6;
		profileButton = new Array<ProfileButton>();
		for (int j = 0; j < profileCount; j++) {
			Profile profile = new Profile("Jaime", Gender.MALE);
			ProfileButton actor = new ProfileButton();
			actor.addListener(profileButtonListener);
			profileButton.add(actor);
		}
	}

	class ProfileButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			super.clicked(event, x, y);
			newUserStage.show();
		}

	}

}
