package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.utils.Constants;

public class Flower extends ImageGameObject {

	private ImageGameObject flowerHead;
	private ImageGameObject flowerBranch;

	public Flower() {
		flowerHead = new ImageGameObject(
				ColorFishingAsset.instance.gameAsset.flowerHead);
		flowerBranch = new ImageGameObject(
				ColorFishingAsset.instance.gameAsset.flowerBranch);
		
		flowerHead.setColor(Color.GREEN);
	}
	
	@Override
	public void setPosition(float x, float y){
		flowerHead.setPosition(x, y);
	}

	@Override
	public float getWidth(){
		return flowerHead.getWidth();
	}

	

	@Override
	public float getHeight(){
		return flowerHead.getHeight() + flowerBranch.getHeight();
	}
	
	@Override
	public void update(float deltaTime) {
		flowerHead.setRotation(flowerHead.getRotation() + 1000 * deltaTime);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		flowerHead.draw(batch, parentAlpha);
		flowerBranch.draw(batch, parentAlpha);
	}
}
