package com.minutegamez.framework;

import com.badlogic.gdx.audio.Sound;

public class CustomSound implements Sound {
	private Sound sound;
	private float duration;

	
	public CustomSound(Sound sound, float duration){
		setSound(sound);
		setDuration(duration);
	}
	
	
	
	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	@Override
	public long play() {
		return sound.play();
	}

	@Override
	public long play(float volume) {
		return sound.play(volume);
	}

	@Override
	public long play(float volume, float pitch, float pan) {
		return sound.play(volume, pitch, pan);
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
		// TODO Auto-generated method stub

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
}
