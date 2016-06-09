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
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.utils.Constants;

public class PauseStage extends PopupStage {

	public static final int RESPONSE_RESUME = 100;
	public static final int RESPONSE_QUIT = 101;
	public static final int RESPONSE_HELP = 102;

	private Skin skin;

	private Button btnResume;
	private Button btnQuit;
	private Button btnHelp;

	private Table table;

	public PauseStage(Batch batch, TweenManager manager) {
		super(batch, manager);
		skin = PopupAsset.instance.pauseSkin;
		listener = new ButtonListener();

		initGameObjects();
		setSizes();
		setPositions();
		addListeners();

		addActor(table);
	}

	private void addListeners() {
		btnResume.addListener(listener);
		btnQuit.addListener(listener);
		btnHelp.addListener(listener);
	}

	private void initGameObjects() {
		table = new Table();
		table.setTransform(true);

		btnResume = new Button(skin, "resume");
		btnQuit = new Button(skin, "quit");
		btnHelp = new Button(skin, "help");
		table.setBackground(skin.getDrawable("background"));
	}

	private void setPositions() {
		Constants.setPosToCenter(table);
		table.add(btnResume);
		table.row();
		table.add(btnHelp);
		table.row();
		table.add(btnQuit);
	}

	private void setSizes() {
		table.setSize(300, 300);
		Constants.setOriginToCenter(table);
	}

	class ButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			System.out.println("click");			if (getState() == STATE_ANIMATION_FINISHED) {
				if (event.getTarget().equals(btnResume)) {
					setResponse(RESPONSE_RESUME);
					System.out.println("reume");
				} else if (event.getTarget().equals(btnQuit)) {
					setResponse(RESPONSE_QUIT);
				} else if (event.getTarget().equals(btnHelp)) {
					setResponse(RESPONSE_HELP);
				}
			}
			super.clicked(event, x, y);
		}
	}

	@Override
	public void setResponse(int response) {
		this.response = response;
		switch (getResponse()) {
		case RESPONSE_RESUME:
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

}
