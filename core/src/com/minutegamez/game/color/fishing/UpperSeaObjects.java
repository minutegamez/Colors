package com.minutegamez.game.color.fishing;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.minutegamez.framework.ImageGameObject;

public class UpperSeaObjects extends ImageGameObject{
	private Boat boat;
	private Wave frontWave;
	private Wave backWave;
	
	public UpperSeaObjects(TweenManager tweenManager){
		backWave = new Wave(ColorFishingAsset.instance.gameAsset.backWave,
				tweenManager, .2f);
		frontWave = new Wave(ColorFishingAsset.instance.gameAsset.frontWave,
				tweenManager, .3f);
		boat = new Boat(tweenManager);
		

		frontWave.setY(6.1f);
		
		frontWave.startAnimation();
		backWave.startAnimation();
	}

	@Override
	public void update(float deltaTime) {
		backWave.update(deltaTime);
		boat.update(deltaTime);
		frontWave.update(deltaTime);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		backWave.draw(batch, parentAlpha);
		boat.draw(batch, parentAlpha);
		frontWave.draw(batch, parentAlpha);
	}

	public Boat getBoat() {
		return boat;
	}
	
	
	
}
