package com.minutegamez.framework;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class AbstractGameObject {

	private float x, y;
	private float width, height;
	private float originX, originY;
	private float scaleX = 1, scaleY = 1;
	private float rotation;
	private Rectangle bounds;
	private Color color = new Color(1, 1, 1, 1);
	private boolean flipX, flipY;

	private TextureRegion region;
	private boolean visible = true, debug;

	public AbstractGameObject() {
		this.bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}

	public float getX() {
		return x;
	}

	public void setDimension(float width, float height) {
		setWidth(width);
		setHeight(height);
	}

	public void setOrigin(float x, float y) {
		setOriginX(x);
		setOriginY(y);
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getOriginX() {
		return originX;
	}

	public void setOriginX(float originX) {
		this.originX = originX;
	}

	public float getOriginY() {
		return originY;
	}

	public void setOriginY(float originY) {
		this.originY = originY;
	}

	public float getScaleX() {
		return scaleX;
	}

	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}

	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public TextureRegion getRegion() {
		return region;
	}

	public void setRegion(TextureRegion region) {
		this.region = region;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void update(float deltaTime) {

	}

	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		setBounds(x, y, getWidth(), getHeight());
	}

	public void render(SpriteBatch batch) {
		if (visible) {
			if (region != null) {
				batch.draw(getRegion(), getX(), getY(), getOriginX(),
						getOriginY(), getWidth(), getHeight(), getScaleX(),
						getScaleY(), rotation);
			}
		}
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(float x, float y, float width, float height) {
		setX(x);
		setY(y);
		setDimension(width, height);
	}

	public void setScale(float x, float y) {
		setScaleX(x);
		setScaleY(y);
	}

	public boolean isFlipX() {
		return flipX;
	}

	public void setFlipX(boolean flipX) {
		this.flipX = flipX;
	}

	public boolean isFlipY() {
		return flipY;
	}

	public void setFlipY(boolean flipY) {
		this.flipY = flipY;
	}

}
