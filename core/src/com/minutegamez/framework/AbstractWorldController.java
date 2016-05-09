package com.minutegamez.framework;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.minutegamez.game.color.fishing.GroupObject;
import com.minutegamez.utils.Constants;

public abstract class AbstractWorldController extends InputAdapter {

	public static final int STATE_RUNNING = 100;
	public static final int STATE_PAUSED = 101;
	public static final int STATE_LEVEL_END = 101;

	protected TweenManager tweenManager;
	protected GroupObject groupObject;
	protected Vector3 touchPoint;
	protected SpriteBatch batch;
	protected OrthographicCamera camera;
	protected int state;

	public AbstractWorldController(TweenManager tweenManager) {
		this.tweenManager = tweenManager;
		touchPoint = new Vector3();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,
				Constants.VIEWPORT_HEIGHT);
		camera.position.set(Constants.VIEWPORT_WIDTH / 2,
				Constants.VIEWPORT_HEIGHT / 2, 0);
		camera.update();
		setObjectGroup(new GroupObject());
		setState(STATE_PAUSED);
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		camera.unproject(touchPoint.set(screenX, screenY, 0));
		touchDown(touchPoint);
		return super.touchDown(screenX, screenY, pointer, button);
	}

	public abstract void init();

	public abstract void update(float delta);

	public void touchUp(Vector3 touchPoint) {
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public abstract void touchDown(Vector3 touchPoint);

	public void touchDragged(Vector3 touchPoint) {

	}

	protected boolean collided(Actor actor, Vector3 p) {
	
		return actor.getX() <= p.x && actor.getX() + actor.getWidth() >= p.x && actor.getY() <= p.y
				&& actor.getY() + actor.getHeight() >= p.y;
	}

	public GroupObject getObjectGroup() {
		return groupObject;
	}

	public void setObjectGroup(GroupObject objectGroup) {
		this.groupObject = objectGroup;
	}

}
