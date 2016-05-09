package com.minutegamez.framework.popup;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.utils.Constants;

public class RunningStage extends PopupStage {

	public static final int RESPONSE_PAUSE = 100;

	private Skin skin;

	private Button btnPause;

	private ButtonListener listener;

	public RunningStage(Batch batch, TweenManager manager) {
		super(batch, manager);
		skin = PopupAsset.instance.runningSkin;

		listener = new ButtonListener();

		initGameObjects();
		setSizes();
		setPositions();
		addListeners();
		addActor(btnPause);
	}

	private void addListeners() {
		btnPause.addListener(listener);
	}

	@Override
	public void setAsInputProcessor(){
		//do nothing bec this is not a popup
	}

	private void setSizes() {

	}

	private void initGameObjects() {
		btnPause = new Button(skin, "pause");
	}

	private void setPositions() {
		btnPause.setPosition(Constants.GUI_WIDTH - btnPause.getWidth(),
				Constants.GUI_HEIGHT - btnPause.getHeight());
	}

	class ButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			if (event.getTarget().equals(btnPause)) {
				setResponse(RESPONSE_PAUSE);
			}
			super.clicked(event, x, y);
		}
	}

}
