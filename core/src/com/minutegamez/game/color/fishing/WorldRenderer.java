package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minutegamez.framework.AbstractWorldController;
import com.minutegamez.framework.AbstractWorldRenderer;

public class WorldRenderer extends AbstractWorldRenderer{

	AbstractWorldController controller;

	public WorldRenderer(AbstractWorldController controller){
		this.controller = controller;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		controller.getObjectGroup().render(batch);
		batch.end();
	}

}
