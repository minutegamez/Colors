package com.minutegamez.screens.profile;

import com.badlogic.gdx.utils.Array;
import com.minutegamez.utils.Constants;

public class GameLevelRatings {

	private Array<LevelRating> levelRatings;
	private String name;
	private int index;

	public GameLevelRatings() {
	}

	public Array<LevelRating> getLevelRatings() {
		return levelRatings;
	}

	public void setLevelRatings(Array<LevelRating> levelRatings) {
		this.levelRatings = levelRatings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static GameLevelRatings create(String name, int index) {
		GameLevelRatings gameLevelRatings = new GameLevelRatings();
		gameLevelRatings.setName(name);
		gameLevelRatings.setIndex(index);
		Array<LevelRating> levelRatings = new Array<LevelRating>();
		for (int j = 0; j < Constants.MAX_LEVEL; j++) {
			levelRatings.add(LevelRating.create(j));
		}
		gameLevelRatings.setLevelRatings(levelRatings);
		return gameLevelRatings;
	}
}
