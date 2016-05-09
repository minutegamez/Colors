package com.minutegamez.framework;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.minutegamez.utils.Constants;

public abstract class PopupStage extends Stage {

	public static final int RESPONSE_NONE = 98;
	private static final int RESPONSE_PENDING = 99;

	public static final int STATE_NONE = 96;
	public static final int STATE_ON_ENTRANCE_ANIMATION = 97;
	public static final int STATE_ON_EXIT_ANIMATION = 98;
	public static final int STATE_ANIMATION_FINISHED = 99;

	protected TweenCallback animationCallback;

	protected TweenCallback callback;
	protected EventListener listener;

	protected InputProcessor lastInputProcessor;

	private int state;
	protected int response;
	public TweenManager manager;

	protected PopupStage popup;

	public InputProcessor getLastInputProcessor() {
		return lastInputProcessor;
	}

	public void setLastInputProcessor(InputProcessor lastInputProcessor) {
		this.lastInputProcessor = lastInputProcessor;
	}

	public PopupStage(Batch batch, TweenManager manager) {
		super(new StretchViewport(Constants.GUI_WIDTH, Constants.GUI_HEIGHT),
				batch);
		batch.enableBlending();
		this.manager = manager;
		animationCallback = new AnimationCallback();
		setResponse(RESPONSE_NONE);
	}

	public void show() {
		setResponse(RESPONSE_NONE);
		setState(STATE_ON_ENTRANCE_ANIMATION);
		showEntranceAnimation();
	}

	public void setAsInputProcessor() {
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void draw() {
		super.draw();
		float delta = Gdx.graphics.getDeltaTime();
		if (popup != null) {
			popup.update(delta);
			popup.draw();
		}
		update(delta);
	}

	public void update(float deltaTime) {

	}

	public void hide() {
		showExitAnimation();
		setState(STATE_ON_EXIT_ANIMATION);
	}

	public void showEntranceAnimation() {
		Tween.to(null, 0, 0).target(0).setCallback(animationCallback)
				.start(manager);
	}

	public void showExitAnimation() {
		Tween.to(null, 0, 0).target(0).setCallback(animationCallback)
				.start(manager);
	}

	public int getResponse() {
		if (state == STATE_ON_ENTRANCE_ANIMATION
				|| state == STATE_ON_EXIT_ANIMATION) {
			return RESPONSE_PENDING;
		}
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public PopupStage getPopup() {
		return popup;
	}

	public void setPopup(PopupStage popup) {
		this.popup = popup;
		popup.show();
	}

	class AnimationCallback implements TweenCallback {

		@Override
		public void onEvent(int arg0, BaseTween<?> arg1) {
			switch (getState()) {
			case STATE_ON_ENTRANCE_ANIMATION:
				setLastInputProcessor(Gdx.input.getInputProcessor());
				setAsInputProcessor();
				setState(STATE_ANIMATION_FINISHED);
				break;
			case STATE_ON_EXIT_ANIMATION:
				setState(STATE_ANIMATION_FINISHED);
				Gdx.input.setInputProcessor(getLastInputProcessor());
				break;
			}
		}
	}

}
