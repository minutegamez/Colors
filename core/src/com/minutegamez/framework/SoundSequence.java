package com.minutegamez.framework;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Array;

public class SoundSequence implements Sound {
	private Array<CustomSound> sounds;
	private float stateTime = 0;
	private int index = 0;
	private boolean running = false;

	public SoundSequence(CustomSound... sounds) {
		this.sounds = new Array<CustomSound>();
		for (CustomSound sound : sounds) {
			this.sounds.add(sound);
		}
	}

	@Override
	public long play() {
		running = true;
		if (running && index < sounds.size) {
			sounds.get(index).play();
		}
		return 0;
	}

	@Override
	public long play(float volume) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long play(float volume, float pitch, float pan) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void set(int index, Sound sound, float duration) {

	}

	public void set(int index, Sound sound) {
		sounds.get(index).setSound(sound);
	}

	@Override
	public long loop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long loop(float volume) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long loop(float volume, float pitch, float pan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void stop() {
		if (running && index < sounds.size) {
			sounds.get(index).stop();
		}
		index = 0;
		stateTime = 0;
		running = false;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop(long soundId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause(long soundId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume(long soundId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLooping(long soundId, boolean looping) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPitch(long soundId, float pitch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVolume(long soundId, float volume) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPan(long soundId, float pan, float volume) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPriority(long soundId, int priority) {
		// TODO Auto-generated method stub

	}

	public void update(float delta) {
		if (running) {
			stateTime += delta;
			float duration = sounds.get(index).getDuration();
			if (stateTime >= duration) {
				index++;
				if (index < sounds.size) {
					play();
					stateTime = 0;
				} else {
					stop();
				}
			}
		}
	}

	public boolean isRunning() {
		return running;
	}
}
