//package com.minutegamez.game.color.fishing;
//
//import aurelienribon.tweenengine.Tween;
//import aurelienribon.tweenengine.TweenManager;
//import aurelienribon.tweenengine.equations.Quint;
//
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.utils.Array;
//import com.minutegamez.elearning.color.fishing.AssetColorFishing;
//import com.minutegamez.elearning.color.objects.GameObject;
//import com.minutegamez.elearning.color.objects.Image;
//import com.minutegamez.elearning.color.objects.ObjectAccessor;
//import com.minutegamez.elearning.color.util.Constants;
//import com.minutegamez.framework.AbstractGameObject;
//
//public class Hint extends AbstractGameObject {
//
//	private enum State {
//		ENTRANCE, SHOW, EXIT, NONE
//	}
//
//	private State state;
//
//	private final float ENTRANCE_TIME = 1.0f;
//	private final float SHOW_TIME = 2.0f;
//
//	private Image color;
//	private Array<AtlasRegion> colors;
//
//	private TweenManager manager;
//
//	private TextureRegion monkey;
//
//	private Array<Image> arrows;
//
//	private float stateTime;
//
//	private int numOfError;
//
//	public Hint(TweenManager manager) {
//		this.manager = manager;
//
//		colors = AssetColorFishing.instance.game.colors;
//		TextureRegion region = colors.get(0);
//		color = new Image(region, region.getRegionWidth()
//				/ Constants.PIXEL_RATIO_X, region.getRegionHeight()
//				/ Constants.PIXEL_RATIO_Y);
//		monkey = AssetColorFishing.instance.game.hint;
//		
//		color.updatePosition(-color.dimension.x, color.dimension.y);
//
//		float width = monkey.getRegionWidth() / Constants.PIXEL_RATIO_X;
//		float height = monkey.getRegionHeight() / Constants.PIXEL_RATIO_Y;
//		dimension.set(width, height);
//		position.set(Constants.VIEWPORT_WIDTH / 2 - width / 2, -height);
//
//		region = AssetColorFishing.instance.game.arrow;
//		width = region.getRegionWidth() / Constants.PIXEL_RATIO_X;
//		height = region.getRegionHeight() / Constants.PIXEL_RATIO_Y;
//		
//		arrows = new Array<Image>();
//		arrows.add(new Image(region, width, height));
//		arrows.add(new Image(region, width, height));
//
//		arrows.get(0).updatePosition(5.7f, 2.7f);
//		arrows.get(0).scale.set(.7f, .7f);
//		arrows.get(0).rotation = -50;
//		
//		arrows.get(1).updatePosition(8, 2.7f);
//		arrows.get(1).scale.set(.7f, .7f);
//		arrows.get(1).rotation = 230;
//		state = State.NONE;
//	}
//
//	public void resetError() {
//		numOfError = 0;
//	}
//
//	public boolean addError(int targetColor) {
//		numOfError++;
//		if (numOfError >= 2) {
//			resetError();
//			show(targetColor);
//			return true;
//		}
//		return false;
//	}
//
//	public void show(int colorIndex) {
//		reset();
//		state = State.ENTRANCE;
//		color.currentRegion = colors.get(colorIndex);
//		Tween.to(this, ObjectAccessor.POS_Y, 1).ease(Quint.IN)
//				.target(-dimension.y / 4).start(manager);
//	}
//
//	@Override
//	public void render(SpriteBatch batch) {
//		batch.draw(monkey.getTexture(), position.x, position.y, origin.x,
//				origin.y, dimension.x, dimension.y, scale.x, scale.y, rotation,
//				monkey.getRegionX(), monkey.getRegionY(),
//				monkey.getRegionWidth(), monkey.getRegionHeight(), false, false);
//		color.render(batch);
//
//		if (state == State.SHOW) {
//			arrows.get(0).render(batch);
//			arrows.get(1).render(batch);
//		}
//	}
//
//	@Override
//	public void update(float deltaTime) {
//		switch (state) {
//		case ENTRANCE:
//			stateTime += deltaTime;
//			if (stateTime >= ENTRANCE_TIME) {
//				state = State.SHOW;
//				Tween.to(arrows.get(0), ObjectAccessor.CPOS_XY, .5f)
//						.target(7, 3.2f).repeatYoyo(3, 0).start(manager);
//				Tween.to(arrows.get(1), ObjectAccessor.CPOS_XY, .5f)
//				.target(8.5f, 3.2f).repeatYoyo(3, 0).start(manager);
//
//				reset();
//			}
//			break;
//		case EXIT:
//			break;
//		case SHOW:
//			stateTime += deltaTime;
//			if (stateTime >= SHOW_TIME) {
//				state = State.EXIT;
//				reset();
//				hide();
//			}
//			break;
//		default:
//			break;
//		}
//		color.updatePosition(position.x + dimension.x / 2 - color.dimension.x
//				/ 2 + .2f, position.y + dimension.y / 2 + color.dimension.y / 2);
//	}
//
//	private void hide() {
//		Tween.to(this, ObjectAccessor.POS_Y, 1).target(-dimension.y)
//				.start(manager);
//	}
//
//	private void reset() {
//		stateTime = 0;
//	}
//}
