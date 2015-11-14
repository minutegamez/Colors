package com.minutegamez.screens.profile;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.guiassets.ProfileAssets;
import com.minutegamez.guiassets.UIAssets;
import com.minutegamez.utils.Constants;

public class NewProfileStage extends PopupStage {

	public static final int RESPONSE_PROFILE_CREATED = 100;

	private Skin skin;

	private Button btnCancel;
	private Button btnSave;
	private Button btnMale;
	private Button btnFemale;

	private TextField txtName;
	private TextField txtAge;

	private Image imgName;
	private Image imgGender;
	private Image imgAge;

	private Table table;
	private Table tblStar;

	private Gender gender;

	public NewProfileStage(Batch batch, TweenManager manager) {
		super(batch, manager);
		skin = ProfileAssets.instance.newProfileSkin;
		listener = new ButtonListener();

		initGameObjects();
		setSizes();
		setPositions();
		addListeners();

		addActor(table);
		setDebugAll(true);
	}

	private void addListeners() {
		btnCancel.addListener(listener);
		btnSave.addListener(listener);
		btnMale.addListener(listener);
		btnFemale.addListener(listener);
	}

	private void initGameObjects() {

		Skin uiSkin = UIAssets.uiSkin;

		table = new Table();
		tblStar = new Table();
		table.setTransform(true);

		btnCancel = new Button(skin, "cancel");
		btnSave = new Button(skin, "save");
		btnMale = new Button(skin, "male");
		btnFemale = new Button(skin, "female");

		txtName = new TextField("", uiSkin);
		txtAge = new TextField("", uiSkin);

		imgName = new Image(skin.getRegion("lblName"));
		imgGender = new Image(skin.getRegion("lblGender"));
		imgAge = new Image(skin.getRegion("lblAge"));

		table.setBackground(skin.getDrawable("background"));
	}

	private void setPositions() {
		Constants.setPosToCenter(table);

		table.add(imgName);
		table.add(txtName);
		table.row();
		table.add(imgAge);
		table.add(txtAge);
		table.row();
		table.add(imgGender);
		table.add(btnMale);
		table.add(btnFemale);
		table.row();
		table.add(btnSave);
		table.add(btnCancel);
	}

	private void setSizes() {
		table.setSize(537, 384);
		Constants.setOriginToCenter(table);
	}

	public void init(int numOfStars) {

		tblStar.clearChildren();

	}

	class ButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			if (getState() == STATE_ANIMATION_FINISHED) {
				if (event.getTarget().equals(btnSave)) {
					System.out.println("Name: " + txtName.getText());
					System.out.println("Age: " + txtAge.getText());

					Profile profile = Profile.create();
					profile.setName(txtName.getText());
					profile.setAge(Integer.parseInt(txtAge.getText()));
					profile.setGender(gender);
					GameService.instance.getProfiles().add(profile);
					GameService.instance.persist();
					setResponse(RESPONSE_PROFILE_CREATED);
					hide();
				} else if (event.getTarget().equals(btnCancel)) {
					hide();
				} else if (event.getTarget().equals(btnMale)) {
					if (btnFemale.isChecked()) {
						btnFemale.toggle();
					}
					gender = Gender.MALE;
				} else if (event.getTarget().equals(btnFemale)) {
					if (btnMale.isChecked()) {
						btnMale.toggle();
					}
					gender = Gender.FEMALE;
				}
			}
			super.clicked(event, x, y);
		}
	}

	@Override
	public void setResponse(int response) {
		this.response = response;
		// switch (getResponse()) {
		// case RESPONSE_RESUME:
		// hide();
		// break;
		// }
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

}
