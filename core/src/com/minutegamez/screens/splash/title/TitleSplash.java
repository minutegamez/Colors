package com.minutegamez.screens.splash.title;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;
import aurelienribon.tweenengine.equations.Elastic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Interpolation;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.DirectedGame;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.framework.Renderer;
import com.minutegamez.framework.SplashScreen;
import com.minutegamez.screens.profile.ProfileScreen;
import com.minutegamez.screens.transition.ScreenTransition;
import com.minutegamez.screens.transition.ScreenTransitionSlide;

public class TitleSplash extends SplashScreen {

	private Renderer renderer;

	public ImageGameObject background;
	public ImageGameObject colorsLabel;
	public ImageGameObject forKidsLabel;
	private TweenManager tweenManager;

	public TitleSplash(DirectedGame game) {
		super(game);
		tweenManager = new TweenManager();
		background = new Background();
		colorsLabel = new ColorsLabel();
		forKidsLabel = new ForKidsLabel();
		renderer = new ScreenRenderer(this);
		state = State.PLAYING;
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		renderer.render(batch);
	}

	public void update(float delta) {
		tweenManager.update(delta);
		switch (state) {
		case PAUSED:
			break;
		case PLAYING:
			break;
		default:
			break;
		}
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	// "Colors"
	// "for kids"
	// (1 sec delay) animation
	private void startLabelAnimation() {
		Timeline.createSequence()
				.push(Tween.to(background, ActorAccessor.OPACITY, 1).target(1))
				.push(Timeline
						.createParallel()
						.push(Tween.to(colorsLabel, ActorAccessor.POS_X, 1.5f)
								.target(50).ease(Elastic.OUT))
						.push(Tween
								.to(colorsLabel, ActorAccessor.SCALE_XY, .1f)
								.repeatYoyo(1, 0).target(.5f, 1)))
				.push(Timeline
						.createParallel()
						.push(Tween
								.to(forKidsLabel, ActorAccessor.SCALE_XY, 1)
								.ease(Back.IN).target(1, 1))
						.push(Tween.to(forKidsLabel, ActorAccessor.OPACITY,
								.5f).target(1)))
						//delay 1 sec
						.push(Tween.to(null, 0, 1f))
				.setCallback(new FinishedLabelAnimation()).start(tweenManager);
	}

	@Override
	public void resume() {
		startLabelAnimation();
	}

	// Event
	class FinishedLabelAnimation implements TweenCallback {
		@Override
		public void onEvent(int arg0, BaseTween<?> arg1) {
			ScreenTransition screenTransition = ScreenTransitionSlide.init(1f,
					ScreenTransitionSlide.DOWN, true, Interpolation.bounceOut);
			game.setScreen(new ProfileScreen(game), screenTransition);
			state = State.PAUSED;
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}


}
