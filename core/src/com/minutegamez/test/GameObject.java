package com.minutegamez.test;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameObject {

	public Vector2 position;
	public Vector2 dimension;
	public Vector2 origin;
	public Vector2 scale;
	public boolean flipX;
	public boolean flipY;
	public Rectangle bounds;
	public Color color;
	public float rotation;
	public Body body;

	public GameObject() {
		position = new Vector2(0, 0);
		origin = new Vector2();
		scale = new Vector2(1, 1);
		dimension = new Vector2(1, 1);
		bounds = new Rectangle();
		color = new Color(1, 1, 1, 1);
		flipX = false;
		flipY = false;
		rotation = 0;
	}

	public void update(float deltaTime) {

	}

	public abstract void render(SpriteBatch batch);

	public void setPosition(float x, float y){
		this.position.set(x, y);
		this.bounds.set(x, y, dimension.x, dimension.y);
	}
}
