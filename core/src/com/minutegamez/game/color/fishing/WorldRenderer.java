package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.framework.AbstractWorldController;
import com.minutegamez.framework.AbstractWorldRenderer;

public class WorldRenderer extends AbstractWorldRenderer{

	WorldController controller;

	public WorldRenderer(SpriteBatch batch, WorldController controller){
		super(batch);
		this.controller = controller;
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		controller.getObjectGroup().draw(batch, 1f);
		controller.bubbleTest.draw(batch);
		controller.bubbleTest2.draw(batch);
		batch.end();
//		System.out.println("drawing");
	}

}
