package com.minutegamez.framework;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.utils.Array;

public class ParticleObjects extends ImageGameObject {
	private int index;
	private Array<ParticleEffect> particleObjects;

	public ParticleObjects(Array<ParticleEffect> particleEffect) {
		particleObjects = particleEffect;
	}

	@Override
	public void setPosition(float x, float y){
		getParticle().setPosition(x, y);
	}
	
	public ParticleEffect getParticle() {
		return particleObjects.get(index);
	}

	public void update(float deltaTime) {
		for (ParticleEffect particleObject : particleObjects) {
			particleObject.update(deltaTime);
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (ParticleEffect particleObject : particleObjects) {
			particleObject.draw(batch);
		}
	}

	public void start() {
		ParticleEffect particleObject = particleObjects.get(index);
		particleObject.start();
		if (index + 1 < particleObjects.size) {
			index++;
		} else {
			index = 0;
		}
	}

	public void start(float x, float y) {
		ParticleEffect particleObject = particleObjects.get(index);
		particleObject.setPosition(x, y);
		start();
	}

	public void setColor(Color color) {
		ParticleEffect particleObject = particleObjects.get(index);
		particleObject.getEmitters().get(0).getTint()
				.setColors(new float[] { color.r, color.g, color.b, color.a });
	}

	public void dispose() {
		for (ParticleEffect particleObject : particleObjects) {
			particleObject.dispose();
		}
	}

}