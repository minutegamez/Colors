package com.minutegamez.animationtest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.AbstractGameScreen;
import com.minutegamez.framework.DirectedGame;

public class AnimationScreen extends AbstractGameScreen {

	private boolean loaded = false;
	public static final String TEXTURE_SPLASH = "animation/animation.atlas";

	private Array<AtlasRegion> regions;
	Monkey fish;
	AssetManager m = new AssetManager();

	public AnimationScreen(DirectedGame game) {
		super(game);
		m.load(TEXTURE_SPLASH, TextureAtlas.class);
		m.finishLoading();

		TextureAtlas atlas = m.get(TEXTURE_SPLASH);
		regions = atlas.findRegions("anim");
		fish = new Monkey(regions);
	}

	private void init() {
		
	}

	@Override
	public void draw() {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(guiCam.combined);
		batch.begin();	
		fish.draw(batch, 1);
		batch.end();
	}

	@Override
	public void update(float delta) {
		fish.update(delta);
	}

	private void checkLevelEndStageResponse() {

	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void resume() {
//		setPopup(loadingScreen);
		// worldController.init();
		super.resume();
	}

	@Override
	public void dispose() {
		m.dispose();
	}

}
