package com.minutegamez.framework.popup;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.utils.Constants;

public class ReadyStage extends PopupStage {

	public static final int RESPONSE_ANIMATION_FINISHED = 100;

	private Skin skin;

	private Image imgReady;
	private Image imgGo;

	public ReadyStage(Batch batch, TweenManager manager) {
		super(batch, manager);
		skin = PopupAsset.instance.readySkin;
		listener = new ButtonListener();
		callback = new Callback();

		initGameObjects();
		setSizes();
		setPositions();
		addListeners();

		addActor(imgReady);
		addActor(imgGo);

	}

	private void addListeners() {
	}

	private void initGameObjects() {
		imgReady = new CustomImage(skin.getRegion("lbl-ready"));
		imgGo = new CustomImage(skin.getRegion("lbl-go"));

		Constants.setOriginToCenter(imgReady);
		Constants.setOriginToCenter(imgGo);
	}

	private void setPositions() {
		Constants.setPosToCenter(imgReady);
		Constants.setPosToCenter(imgGo);
	}

	private void setSizes() {
	}

	public void startAnimation() {
		imgReady.scaleBy(1.5f, 1.5f);
		imgGo.scaleBy(1.5f, 1.5f);
		Color color = imgGo.getColor();
		// System.out.println(imgGo.getColor().r + " " + imgGo.getColor().g +
		// " " + imgGo.getColor().b);
		imgGo.setColor(color.r, color.g, color.b, 0f);

		Timeline.createSequence()
				.push(Tween.to(imgReady, ActorAccessor.SCALE_XY, 1)
						.ease(Back.IN).target(0, 0))
				.push(Tween.to(imgGo, ActorAccessor.OPACITY, 0)
						.target(1))
				.push(Tween.to(imgGo, ActorAccessor.SCALE_XY, 1).ease(Back.IN)
						.target(0, 0)).setCallback(callback).start(manager);

	}

	@Override
	public void show() {
		startAnimation();
	}

//	@Override
//	public void hide() {
//		setResponse(RESPONSE_NONE);
//	}

	class ButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			super.clicked(event, x, y);
		}
	}

	class Callback implements TweenCallback {

		@Override
		public void onEvent(int arg0, BaseTween<?> arg1) {
			setResponse(RESPONSE_ANIMATION_FINISHED);
		}

	}

	@Override
	public void showEntranceAnimation() {

	}

	@Override
	public void showExitAnimation() {

	}
}
