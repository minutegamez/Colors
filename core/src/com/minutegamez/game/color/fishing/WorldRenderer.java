package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.framework.AbstractWorldController;
import com.minutegamez.framework.AbstractWorldRenderer;

public class WorldRenderer extends AbstractWorldRenderer{

	AbstractWorldController controller;

	public WorldRenderer(SpriteBatch batch, AbstractWorldController controller){
		super(batch);
		this.controller = controller;
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		controller.getObjectGroup().draw(batch, 1f);
		batch.end();
//		System.out.println("drawing");
	}

}
