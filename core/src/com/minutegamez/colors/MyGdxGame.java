package com.minutegamez.colors;

import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.DirectedGame;
import com.minutegamez.guiassets.GUIAssetsLoader;
import com.minutegamez.screens.profile.ProfileScreen;
import com.minutegamez.screens.transition.ScreenTransition;
import com.minutegamez.screens.transition.ScreenTransitionFade;

public class MyGdxGame extends DirectedGame {
	private static final String TAG = Class.class.getName();

	private GUIAssetsLoader guiAssets;

	@Override
	public void dispose() {
		super.dispose();
		guiAssets.dispose();
	}

	@Override
	public void create() {
		initAssets();
		registerTweenAccessor();
		ScreenTransition screenTransition = new ScreenTransitionFade();
		setScreen(new ProfileScreen(this), screenTransition);
//		setScreen(new AnimationScreen(this), screenTransition);
//		 setScreen(new GameScreen(this), screenTransition);

	}

	private void registerTweenAccessor() {
//		Tween.registerAccessor(AbstractGameObject.class, new ObjectAccessor());
		Tween.registerAccessor(Actor.class, new ActorAccessor());
	}

	private void initAssets() {
		guiAssets = new GUIAssetsLoader();
		guiAssets.load();
	}

	private void reloadAssets() {
		guiAssets.reload();
	}

	@Override
	public void resume() {
		reloadAssets();
	}
}
