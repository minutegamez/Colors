package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.CustomSound;
import com.minutegamez.framework.SoundSequence;
import com.minutegamez.game.color.fishing.ColorFishingAsset.SoundAsset;

public class SoundManager {

	private SoundSequence correctSequence;
	private SoundSequence incorrectSequence;
	private SoundSequence instructionSequence;

	private Array<Sound> colorSounds;
	private Array<Sound> correctSounds;

	private Sound clickSound;
	private Sound levelEndSound;
	private Sound positiveSound;

	private SoundSequence currSoundSequence;

	public SoundManager() {

		SoundAsset assets = ColorFishingAsset.instance.soundAsset;

		incorrectSequence = new SoundSequence(new CustomSound(assets.oopsSound,
				1.6f), new CustomSound(null, 1.0f));

		instructionSequence = new SoundSequence(new CustomSound(assets.findThe,
				1.3f), new CustomSound(null, 1.0f));

		correctSequence = new SoundSequence(new CustomSound(
				assets.positiveSound, 1.0f), new CustomSound(null, 1.0f));

		colorSounds = assets.colors;
		correctSounds = assets.correctSound;

		clickSound = assets.clickSound;
		levelEndSound = assets.levelEndSound;
		positiveSound = assets.positiveSound;

	}

	public void playClickSound() {
		clickSound.play();
	}

	public boolean isRunning() {
		if (currSoundSequence != null) {
			return currSoundSequence.isRunning();
		}
		return false;
	}

	public void playLevelEndSound() {
		levelEndSound.play();
	}

	public void playPositiveSound() {
		positiveSound.play();
	}

	public void playCorrectSound() {
		correctSequence.set(1, correctSounds.random());
		playSequence(correctSequence);
	}

	public void playIncorrectSound(int colorIndex) {
		incorrectSequence.set(1, colorSounds.get(colorIndex));
		playSequence(incorrectSequence);
	}

	public void playInstructionSound(int colorIndex) {
		Sound sound = colorSounds.get(colorIndex);
		instructionSequence.set(1, sound);
		playSequence(instructionSequence);
	}

	public void update(float delta) {
		if (currSoundSequence != null) {
			currSoundSequence.update(delta);
		}
	}

	private void playSequence(SoundSequence sequence) {
		currSoundSequence = sequence;
		currSoundSequence.stop();
		currSoundSequence.play();
	}
}
