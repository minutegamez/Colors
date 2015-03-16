package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {
	public void render(SpriteBatch batch);
	public void setPosition(float x, float y);
	public void update(float deltaTime);
}
