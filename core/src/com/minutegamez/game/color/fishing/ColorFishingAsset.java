package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.guiassets.Asset;
import com.minutegamez.utils.Constants;

public class ColorFishingAsset implements Asset {

	public static final ColorFishingAsset instance = new ColorFishingAsset();
	private static final String TEXTURE_SPLASH = "images/game/fishing/fishing.atlas";
	private static final String TEXTURE_TUTORIAL = "images/game/fishing/tutorial/tutorial_fishing.atlas";

	public GameAsset gameAsset;
	public TutorialAsset tutorialAsset;
	public SoundAsset soundAsset;
	public ParticleAsset particleAsset;

	public ColorFishingAsset() {
		gameAsset = new GameAsset();
		tutorialAsset = new TutorialAsset();
		soundAsset = new SoundAsset();
		particleAsset = new ParticleAsset();
	}

	@Override
	public void reload() {

	}

	@Override
	public void dispose() {
		particleAsset.dispose();
	}

	@Override
	public void load(AssetManager manager) {
		gameAsset.load(manager);
		tutorialAsset.load(manager);
		soundAsset.load(manager);
		particleAsset.load(manager);
	}

	@Override
	public void init(AssetManager manager) {
		gameAsset.init(manager);
		tutorialAsset.init(manager);
		soundAsset.init(manager);
		particleAsset.init(manager);
	}

	public class GameAsset implements Asset {
		public Array<Animation> fishAnimation1;
		public Array<Animation> fishAnimation2;

		public TextureRegion[][] fishRegions1;
		public TextureRegion[][] fishRegions2;
		public Array<TextureRegion> region;
		public Array<AtlasRegion> colors;

		public AtlasRegion backWave;

		public AtlasRegion greenCoral;
		public AtlasRegion blueCoral;
		public AtlasRegion yellowCoral;
		
		public AtlasRegion bubble;
		public AtlasRegion star;
		public Array<AtlasRegion> monkey;
		public Array<AtlasRegion> monkeyHappy;
		public Array<AtlasRegion> monkeyAngry;
		public Array<AtlasRegion> clouds;

		public AtlasRegion background;

		public AtlasRegion flowerBranch;
		public AtlasRegion flowerHead;

		public AtlasRegion boat;

		public Array<AtlasRegion> btnReplay;
		public AtlasRegion hint;
		public AtlasRegion arrow;
		public AtlasRegion emptyFish;
		public AtlasRegion frontWave;

		@Override
		public void load(AssetManager manager) {
			manager.load(TEXTURE_SPLASH, TextureAtlas.class);
			manager.load(TEXTURE_TUTORIAL, TextureAtlas.class);
		}

		@Override
		public void init(AssetManager manager) {
			TextureAtlas atlas = manager.get(TEXTURE_SPLASH);
			colors = atlas.findRegions("color");
			emptyFish = atlas.findRegion("emptyFish");
			arrow = atlas.findRegion("arrow");
			monkey = atlas.findRegions("monkey-normal");
			monkeyHappy = atlas.findRegions("monkey-happy");
			monkeyAngry = atlas.findRegions("monkey-angry");
			boat = atlas.findRegion("boat");
			flowerBranch = atlas.findRegion("flower-branch");
			flowerHead = atlas.findRegion("flower-head");
			background = atlas.findRegion("background");
			Array<AtlasRegion> waveRegions = atlas.findRegions("wave");
			backWave = waveRegions.get(0);
			frontWave = waveRegions.get(1);
			
			clouds = atlas.findRegions("cloud");

			Array<AtlasRegion> corals = atlas.findRegions("coral");
			greenCoral = corals.get(0);
			blueCoral = corals.get(1);
			yellowCoral = corals.get(2);
			

			btnReplay = atlas.findRegions("btnReplay");
			fishAnimation1 = new Array<Animation>();
			fishAnimation2 = new Array<Animation>();

			fishRegions1 = new TextureRegion[Constants.MAX_COLOR][2];
			fishRegions2 = new TextureRegion[Constants.MAX_COLOR][2];

			initAnimationObjects(fishRegions1, atlas, "1");
			initAnimationObjects(fishRegions2, atlas, "2");

			hint = atlas.findRegion("hint");

			// init animation of fish1 and fish2
			for (int j = 0; j < Constants.MAX_COLOR; j++) {
				Array<TextureRegion> fish1 = new Array<TextureRegion>();
				Array<TextureRegion> fish2 = new Array<TextureRegion>();
				for (int k = 0; k < 2; k++) {
					fish1.add(fishRegions1[j][k]);
					fish2.add(fishRegions2[j][k]);
				}
				// create animation
				Animation animation1 = new Animation(1.0f / 3.0f, fish1);
				Animation animation2 = new Animation(MathUtils.random(1.0f,
						1.5f), fish2);
				// add animation
				fishAnimation1.add(animation1);
				fishAnimation2.add(animation2);
			}

			bubble = atlas.findRegion("bubble");
			star = atlas.findRegion("star");

			atlas = manager.get(TEXTURE_TUTORIAL);
			tutorial = atlas.findRegions("tutorial");
		}

		private void initAnimationObjects(TextureRegion[][] region,
				TextureAtlas atlas, String fishIndex) {
			for (int colorIndex = 0; colorIndex < Constants.MAX_COLOR; colorIndex++) {
				for (int index = 0; index < 2; index++) {
					// format - fish-[type]-[color]-[index]
					String name = "fish" + fishIndex + "-" + (colorIndex + 1)
							+ "-" + (index + 1);
					region[colorIndex][index] = atlas.findRegion(name);
				}
			}
		}

		@Override
		public void reload() {

		}

		@Override
		public void dispose() {

		}

	}

	public class TutorialAsset implements Asset {

		@Override
		public void load(AssetManager manager) {

		}

		@Override
		public void init(AssetManager manager) {

		}

		@Override
		public void reload() {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}
	}

	public class ParticleAsset implements Asset {

		public static final String MOVING_STAR_PARTICLE = "data/particle/bubbleburst";
		public static final String FISH_BUBBLE_PARTICLE = "data/particle/fishbubble";

		public ParticleEffect movingStarsParticle;
		public Array<ParticleEffect> fishBubbleParticle;

		@Override
		public void load(AssetManager manager) {
			manager.load(MOVING_STAR_PARTICLE, ParticleEffect.class);
			manager.load(FISH_BUBBLE_PARTICLE, ParticleEffect.class);
		}

		@Override
		public void init(AssetManager manager) {
			ParticleEffect effect = manager.get(MOVING_STAR_PARTICLE,
					ParticleEffect.class);
			movingStarsParticle = effect;
			fishBubbleParticle = new Array<ParticleEffect>();

			ParticleEffect trailingBubbleParticle = manager.get(FISH_BUBBLE_PARTICLE, ParticleEffect.class);
			for (int j = 0; j < Tank.MAX_FISH; j++) {
				fishBubbleParticle.add(new ParticleEffect(trailingBubbleParticle));
			}
		}

		@Override
		public void reload() {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
				movingStarsParticle.dispose();
		}
	}

	public class SoundAsset implements Asset {
		public Sound findThe;
		public Sound clickSound;
		public Array<Sound> correctSound;
		public Sound levelEndSound;
		public Sound oopsSound;
		public Sound positiveSound;
		public Array<Sound> colors;

		@Override
		public void load(AssetManager manager) {
			manager.load("sounds/colors/find_the.ogg", Sound.class);
			manager.load("sounds/click/touch_1.ogg", Sound.class);
			manager.load("sounds/etc/level_end.ogg", Sound.class);
			manager.load("sounds/colors/oops.ogg", Sound.class);
			manager.load("sounds/etc/positive.ogg", Sound.class);

			for (int j = 0; j < 4; j++) {
				String name = "sounds/correct/" + Integer.toString(j) + ".ogg";
				manager.load(name, Sound.class);
			}

			for (int j = 0; j < Constants.MAX_COLOR; j++) {
				String name = "sounds/colors/" + Integer.toString(j) + ".ogg";
				manager.load(name, Sound.class);
			}
		}

		@Override
		public void init(AssetManager manager) {
			colors = new Array<Sound>();
			for (int j = 0; j < Constants.MAX_COLOR; j++) {
				String name = "sounds/colors/" + Integer.toString(j) + ".ogg";
				Sound sound = manager.get(name, Sound.class);
				colors.add(sound);
			}

			findThe = manager.get("sounds/colors/find_the.ogg", Sound.class);
			clickSound = manager.get("sounds/click/touch_1.ogg", Sound.class);
			levelEndSound = manager
					.get("sounds/etc/level_end.ogg", Sound.class);
			oopsSound = manager.get("sounds/colors/oops.ogg", Sound.class);
			positiveSound = manager.get("sounds/etc/positive.ogg", Sound.class);

			correctSound = new Array<Sound>();

			for (int j = 0; j < 4; j++) {
				correctSound.add(manager.get(
						"sounds/correct/" + Integer.toString(j) + ".ogg",
						Sound.class));
			}
		}

		@Override
		public void reload() {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

	}

	public Array<AtlasRegion> tutorial;

}
