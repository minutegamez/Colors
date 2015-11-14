package com.minutegamez.framework;

import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.popup.LevelButton;
import com.minutegamez.screens.profile.LevelRating;
import com.minutegamez.screens.profile.Profile;
import com.minutegamez.screens.profile.GameService;
import com.minutegamez.screens.profile.Score;

public class ScoreManager {

	public float getNumOfTries() {
		return numOfTries;
	}

	public float getNumOfCorrectTries() {
		return numOfCorrectTries;
	}

	public Array<Integer> getErrors() {
		return errors;
	}

	private Profile currProfile;

	/**
	 * The instance representing the number of tries performed by the user on
	 * tapping the fish including the correct and incorrect attempt.
	 * */
	private float numOfTries;

	/**
	 * The instance representing the percentage of accuracy of the user on
	 * colors
	 * */
	private float accuracy;

	/**
	 * The instance representing the number of correct attempt performed by the
	 * user
	 * */
	private float numOfCorrectTries;

	/**
	 * The instance representing the indexes of colors the user missed or failed
	 * to spot
	 * */
	private Array<Integer> errors;

	/**
	 * The instance representing the colorIndex that must have been tapped by
	 * the user purpose is to not populate the data with similar colorIndex
	 * value will be -1 if no errors have been committed, otherwise value is > 0
	 * */
	private int lastError = -1;

	public void setError(int colorIndex) {
		lastError = colorIndex;
	}

	public ScoreManager() {
		errors = new Array<Integer>();
		currProfile = GameService.instance.getSelectedProfile();
	}

	public void update() {
		if (lastError >= 0) {
			errors.add(lastError);
			lastError = -1;
		}
	}

	public void addScore(boolean isCorrect) {
		if (isCorrect) {
			numOfCorrectTries++;
		}
		numOfTries++;
	}

	public void computeAccuracy() {
		if (numOfTries > 0) {
			accuracy = numOfCorrectTries / numOfTries * 100;
		}
	}

	public int getNumOfStars() {
		int gameIndex = GameService.instance.getSelectedGameIndex();
		int levelIndex = GameService.instance.getSelectedLevelIndex();
		
		computeAccuracy();
		int numOfStars = 0;

		if (accuracy == 100f) {
			numOfStars = 3;
		} else if (accuracy >= 75f) {
			numOfStars = 2;
		} else {
			numOfStars = 1;
		}
		Array<LevelRating> levelRatings = currProfile.getGameRatings()
				.get(gameIndex).getLevelRatings();
		LevelRating rating = levelRatings.get(levelIndex);

		if (rating.getNumOfStars() <= numOfStars) {
			rating.setNumOfStars(numOfStars);
			// unlock next level
			if (levelIndex + 1 < levelRatings.size) {
				LevelRating nextLevelRating = levelRatings.get(levelIndex + 1);
				nextLevelRating.setLocked(false);
			}
		}

		return numOfStars;
	}

	public void save() {
		Score score = new Score();
		Array<Integer> scoreError = new Array<Integer>(errors);
		score.setAccuracy(accuracy);
		score.setDifficult(scoreError);
		currProfile.addScore(score);
		GameService.instance.persist();
		reset();
	}

	private void reset() {
		numOfCorrectTries = 0;
		numOfTries = 0;
		errors.clear();
		accuracy = 0;
	}


}
