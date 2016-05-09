package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.utils.Constants;

public class Clouds extends ImageGameObject {

	private Array<ImageGameObject> clouds;

	public Clouds() {
		Array<AtlasRegion> cloudRegions = ColorFishingAsset.instance.gameAsset.clouds;
		clouds = new Array<ImageGameObject>();
		for (int j = 0; j < 3; j++) {
			ImageGameObject cloud = new Cloud(cloudRegions.get(j), 5 * j);
			clouds.add(cloud);
		}
	}

	@Override
	public void update(float deltaTime) {
		for (ImageGameObject cloud : clouds) {
			cloud.update(deltaTime);
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (ImageGameObject cloud : clouds) {
			cloud.draw(batch, parentAlpha);
		}
	}

	class Cloud extends ImageGameObject {
		float speed = 0;

		public Cloud(AtlasRegion region, float x) {
			setRegion(region);
			speed = .3f;
			init();
			setX(x);
		}

		@Override
		public void update(float deltaTime) {
			setX(getX() + speed * deltaTime);
			if (getX() > Constants.VIEWPORT_WIDTH + 1) {
				init();
			}
		}

		private void init() {
			setX(-getWidth());
			setY(MathUtils.random(7.5f, Constants.VIEWPORT_HEIGHT + .5f
					- getHeight()));
		}
	}
}
