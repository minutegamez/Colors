package com.minutegamez.framework.popup;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;
import aurelienribon.tweenengine.equations.Linear;
import aurelienribon.tweenengine.equations.Quint;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.screens.profile.GameService;
import com.minutegamez.screens.profile.LevelRating;
import com.minutegamez.utils.Constants;

public class LevelEndStage extends PopupStage {

	public static final int RESPONSE_REPLAY = 100;
	public static final int RESPONSE_BACK_TO_MENU = 101;
	public static final int RESPONSE_NEXT = 102;
	public static final int RESPONSE_BACK_TO_LEVEL_SELECTION = 103;

	private static final int MAX_STARS = 3;
	private static final int MAX_RATING = 3;

	private Skin skin;

	private Button btnMenu;
	private Button btnNext;
	private Button btnReplay;
	private Array<Image> imgStars;
	private Array<Image> imgRatings;
	private Image currRating;

	private Table table;
	private Table tblStar;

	public LevelEndStage(Batch batch, TweenManager manager) {
		super(batch, manager);
		skin = PopupAsset.instance.levelEndSkin;
		listener = new ButtonListener();

		initGameObjects();
		setSizes();
		setPositions();
		addListeners();

		addActor(table);
		setDebugAll(true);
	}

	private void addListeners() {
		 btnMenu.addListener(listener);
		 btnNext.addListener(listener);
		 btnReplay.addListener(listener);
	}

	private void initGameObjects() {
		table = new Table();
		tblStar = new Table();
		table.setTransform(true);

		btnMenu = new Button(skin, "menu");
		btnNext = new Button(skin, "next");
		btnReplay = new Button(skin, "replay");

		imgStars = new Array<Image>();
		imgRatings = new Array<Image>();

		for (int j = 0; j < MAX_STARS; j++) {
			Image image = new Image(skin.getDrawable("star"));
			imgStars.add(image);
			Constants.setOriginToCenter(image);
		}

		for (int j = 0; j < MAX_RATING; j++) {
			Image image = new Image(skin.getDrawable("rating-" + (j + 1)));
			imgRatings.add(image);
		}

		// set default rating
		currRating = imgRatings.get(0);

		table.setBackground(skin.getDrawable("background"));
	}

	private void setPositions() {
		Constants.setPosToCenter(table);
		table.add(currRating).colspan(3);
		table.row();
		table.add(tblStar).colspan(3);
		table.row();
		table.left().bottom();
		table.add(btnReplay).expandX().align(Align.left);
		table.add(btnNext).expandX().align(Align.center);
		table.add(btnMenu).expandX().align(Align.right);
	}

	private void setSizes() {
		table.setSize(537, 384);
		Constants.setOriginToCenter(table);
	}

	public void init(int numOfStars) {

		tblStar.clearChildren();
		

		for (int j = 0; j < numOfStars; j++) {
			tblStar.add(imgStars.get(j));
		}
		// -1 bec array starts from 0 and numOfStars starts from 1
		currRating = imgRatings.get(numOfStars - 1);
	}

	class ButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			System.out.println("click");
			if (getState() == STATE_ANIMATION_FINISHED) {
				if (event.getTarget().equals(btnMenu)) {
					System.out.println("back to menu");
					setResponse(RESPONSE_BACK_TO_MENU);
				} else if (event.getTarget().equals(btnNext)) {
					System.out.println("bnext");
					setResponse(RESPONSE_NEXT);
				} else if (event.getTarget().equals(btnReplay)) {
					System.out.println("bac replay");
					setResponse(RESPONSE_REPLAY);
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

		for (int j = 0; j < MAX_STARS; j++) {
			Image image = imgStars.get(j);
			image.setRotation(0);

			Timeline.createSequence()
					.push(Timeline.createParallel().push(
							Tween.to(image, ActorAccessor.ROTATION, 1.0F)
									.target(-360.0F).ease(Linear.INOUT)))
					.push((Tween.to(image, ActorAccessor.SCALE_XY, 0.5F)
							.target(1.5F, 0.5F).repeatYoyo(1, 0.0F))
							.ease(Quint.IN)).start(manager);
		}
	}

	@Override
	public void showExitAnimation() {
		Tween.to(table, ActorAccessor.SCALE_XY, .5f).target(0f, 0f)
				.ease(Back.IN).setCallback(animationCallback).start(manager);
	}

}
