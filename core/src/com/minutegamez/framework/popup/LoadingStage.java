package com.minutegamez.framework.popup;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.game.color.fishing.ColorFishingAsset;
import com.minutegamez.guiassets.Asset;
import com.minutegamez.utils.Constants;

public class LoadingStage extends PopupStage {

	public static final int RESPONSE_LOADING_FINISHED = 100;

	private Skin skin;

	private Button btnMenu;
	private Button btnNext;

	private AssetManager assetManager;
	private Asset asset;

	private Table table;

	public LoadingStage(Batch batch, TweenManager manager, Asset asset) {
		super(batch, manager);
		skin = PopupAsset.instance.levelEndSkin;
		listener = new ButtonListener();

		assetManager = new AssetManager();

		initGameObjects();
		setSizes();
		setPositions();
		addListeners();

		this.asset = asset;
		load();

		addActor(table);
		setDebugAll(true);
	}

	private void addListeners() {
		// btnResume.addListener(listener);
	}

	private void initGameObjects() {
		table = new Table();
		table.setTransform(true);

		btnMenu = new Button(skin, "menu");
		btnNext = new Button(skin, "next");

		table.setBackground(skin.getDrawable("background"));
	}

	private void setPositions() {
		Constants.setPosToCenter(table);

	}

	private void setSizes() {
		table.setSize(537, 384);
		Constants.setOriginToCenter(table);
	}

	class ButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			if (getState() == STATE_ANIMATION_FINISHED) {
				// if (event.getTarget().equals(btnResume)) {
				// }
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
	public void draw() {
		super.draw();
		if (getResponse() != RESPONSE_LOADING_FINISHED
				&& getState() == STATE_ANIMATION_FINISHED) {
			assetManager.update();
			if (assetManager.getProgress() == 1.0) {
				setResponse(RESPONSE_LOADING_FINISHED);
				ColorFishingAsset.instance.init(assetManager);
				hide();
			}
		}
	}

	public void load() {
		asset.load(assetManager);
	}

	@Override
	public void dispose() {
		super.dispose();
		assetManager.dispose();
		asset.dispose();
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
