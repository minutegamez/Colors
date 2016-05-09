package com.minutegamez.screens.profile;

import com.badlogic.gdx.utils.Array;

public class Profile {
	private static final String GAME_FISHING_STRING = "FISHING";
	private static final String GAME_MATCH_STRING = "MATCH";
	private static final String GAME_TOUCH_STRING = "TOUCH";
	private static final String GAME_MEMORY_STRING = "MEMORY";
	private static final String GAME_FIND_STRING = "FIND";

	public static final int GAME_FISHING = 0;
	public static final int GAME_MATCH = 1;
	public static final int GAME_TOUCH = 2;
	public static final int GAME_MEMORY = 3;
	public static final int GAME_FIND = 4;

	private static final int MAX_SCORE = 14;

	private int id;
	private String name;
	private int age;
	private Gender gender;
	private Array<GameLevelRatings> gameLevelRatings;
	private Array<Score> scoreHistory;

	public String getName() {
		return name;
	}

	public Profile() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profile(String name) {
		setName(name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Array<Score> getScoreHistory() {
		return scoreHistory;
	}

	public void setScoreHistory(Array<Score> history) {
		this.scoreHistory = history;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Array<GameLevelRatings> getGameRatings() {
		return gameLevelRatings;
	}

	public void setGameRatings(Array<GameLevelRatings> gameRatings) {
		this.gameLevelRatings = gameRatings;
	}

	// default
	public static Profile create() {
		Profile profile = new Profile();
		profile.setName("Default");
		profile.setAge(5);
		profile.setGender(Gender.MALE);
		profile.setId(0);
		Array<Score> scoreHistory = new Array<Score>();
		profile.setScoreHistory(scoreHistory);
		// add default game level ratings
		Array<GameLevelRatings> gameLevelRatings = new Array<GameLevelRatings>();
		gameLevelRatings.add(GameLevelRatings.create(GAME_FISHING_STRING, 0));
		gameLevelRatings.add(GameLevelRatings.create(GAME_MATCH_STRING, 1));
		gameLevelRatings.add(GameLevelRatings.create(GAME_TOUCH_STRING, 2));
		gameLevelRatings.add(GameLevelRatings.create(GAME_MEMORY_STRING, 3));
		gameLevelRatings.add(GameLevelRatings.create(GAME_FIND_STRING, 4));
		profile.setGameRatings(gameLevelRatings);
		return profile;
	}

	public void addScore(Score score) {
		if (scoreHistory.size == MAX_SCORE) {
			scoreHistory.removeIndex(0);
		}

		if (scoreHistory.size > 0) {
			Score lastScore = scoreHistory.get(scoreHistory.size - 1);
			int lastScoreIndex = lastScore.getIndex();
			score.setIndex(lastScoreIndex + 1);

		} else {
			score.setIndex(1);
		}
		scoreHistory.add(score);

		if (score.getIndex() > 25) {
			renameIndexes();
		}
	}

	private void renameIndexes() {
		int index = 1;
		for (int j = 0; j < getScoreHistory().size; j++) {
			Score score = getScoreHistory().get(j);
			score.setIndex(index);
			index++;
		}
	}
}
