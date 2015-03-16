package com.minutegamez.colors;

import aurelienribon.tweenengine.Tween;

import com.minutegamez.framework.DirectedGame;
import com.minutegamez.framework.ObjectAccessor;
import com.minutegamez.guiassets.Assets;
import com.minutegamez.guiassets.GUIAssets;
import com.minutegamez.screens.profile.ProfileScreen;
import com.minutegamez.screens.transition.ScreenTransition;
import com.minutegamez.screens.transition.ScreenTransitionFade;
import com.minutegamez.test.GameObject;

public class MyGdxGame extends DirectedGame {
	private static final String TAG = Class.class.getName();

	private Assets guiAssets;

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

	}

	private void registerTweenAccessor() {
		Tween.registerAccessor(GameObject.class, new ObjectAccessor());
	}

	private void initAssets() {
		guiAssets = new GUIAssets();
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
