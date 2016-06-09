package com.minutegamez.screens.profile;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.guiassets.BackgroundAssets;
import com.minutegamez.guiassets.ProfileAssets;
import com.minutegamez.utils.Constants;

public class ProfileStage extends PopupStage {

	public static final int RESPONSE_PROFILE_SELECTED = 101;

	public static final int POPUP_NEW_PROFILE = 102;

	private static final float BUTTON_COUNT_X = 3;
	private static final int MAX_VISIBLE_BUTTON = 6;

	private PopupStage newProfileStage;

	private Image background;
	private Array<ProfileButton> profileButtons;
	private Skin skin;
	private Array<Profile> profiles;

	private ProfileButtonListener profileButtonListener;

	public ProfileStage(SpriteBatch batch, TweenManager guiTweenManager) {
		super(batch, guiTweenManager);
		this.profiles = GameService.instance.getProfiles();
		skin = ProfileAssets.instance.profileSkin;

		profileButtonListener = new ProfileButtonListener();
		newProfileStage = new NewProfileStage(batch, guiTweenManager);

		initActors();
		addActors();
		setPosition();
		setDebugAll(true);
	}

	@Override
	public void update(float delta) {
		if (popup != null) {
			if (popup.equals(newProfileStage)) {
				switch (newProfileStage.getResponse()) {
				case NewProfileStage.RESPONSE_PROFILE_CREATED:
					popup = null;
					init();
					break;
				}
			}
		}
	}

	private void addActors() {
		addActor(background);

		for (Actor actor : profileButtons) {
			addActor(actor);
		}

		// addActor(newUserStage);
	}

	private void setPosition() {
		// equal divide
		// float offsetWidth = Constants.GUI_WIDTH / BUTTON_COUNT_X;
		// float posX = (offsetWidth / 2) - profileButton.get(0).getWidth() / 2;

		float btnWidth = profileButtons.get(0).getWidth();
		float btnHeight = profileButtons.get(0).getHeight();

		float centerX = Constants.GUI_WIDTH / 2;
		float centerY = Constants.GUI_HEIGHT / 2;

		float gapX = 20.0f;
		float gapY = 5.0f;

		float posX = centerX - btnWidth / 2 - gapX - btnWidth;
		float posY = centerY + gapY;

		for (int j = 0; j < MAX_VISIBLE_BUTTON; j++) {
			Actor actor = profileButtons.get(j);

			actor.setPosition(posX, posY);
			posX += gapX + btnWidth;

			if (j + 1 == BUTTON_COUNT_X) {
				posX = centerX - btnWidth / 2 - gapX - btnWidth;
				posY = centerY - gapY - btnHeight;
			}

		}
	}

	private void initActors() {
		background = new Image(BackgroundAssets.instance.grass_background);
		background.setSize(Constants.GUI_WIDTH, Constants.GUI_HEIGHT);

		int profileCount = Constants.MAX_PROFILE;
		profileButtons = new Array<ProfileButton>();
		for (int j = 0; j < profileCount; j++) {
			Profile profile = null;
			ProfileButton actor = null;
			if (profiles.size > j) {
				profile = profiles.get(j);
				actor = new ProfileButton(skin);
				actor.init(profile);
			} else {
				// if empty profile
				actor = new ProfileButton(skin);
			}
			actor.addListener(profileButtonListener);
			profileButtons.add(actor);
		}
	}

	private void init() {
		Array<Profile> profiles = GameService.instance.getProfiles();
		for (int j = 0; j < profiles.size; j++) {
			Profile profile = profiles.get(j);
			ProfileButton button = profileButtons.get(j);
			button.init(profile);
		}
	}

	@Override
	public void setResponse(int response) {
		super.setResponse(response);
		switch (getResponse()) {
		case RESPONSE_PROFILE_SELECTED:
			break;
		}
	}

	class ProfileButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			super.clicked(event, x, y);
			if (getState() == STATE_ANIMATION_FINISHED) {
				for (ProfileButton button : profileButtons) {
					if (button.isClicked(event.getTarget())) {
						if (button.getProfile() != null) {
							GameService.instance.setSelectedProfile(button
									.getProfile());
							setResponse(RESPONSE_PROFILE_SELECTED);
						} else {
							setPopup(newProfileStage);
						}
						break;
					}
				}
			}
		}
	}

}
