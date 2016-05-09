package com.minutegamez.screens.profile;

public class LevelRating {
	private int index;
	private int numOfStars;
	private boolean locked;

	public LevelRating() {
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getNumOfStars() {
		return numOfStars;
	}

	public void setNumOfStars(int numOfStars) {
		this.numOfStars = numOfStars;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public static LevelRating create(int index) {
		LevelRating levelRating = new LevelRating();
		levelRating.setIndex(index);
		levelRating.setNumOfStars(0);
		// first level should be unlocked
		if (index > 0) {
			levelRating.setLocked(true);
		} else {
			levelRating.setLocked(false);
		}
		return levelRating;
	}
}
