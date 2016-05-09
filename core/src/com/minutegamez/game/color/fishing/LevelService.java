package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.minutegamez.framework.Level;
import com.minutegamez.screens.profile.GameService;

public class LevelService {

	private static final String FILE_LOC = "data/levels/color_fishing.json";

	private Json json;

	private Array<Level> levels;

	public LevelService() {
		levels = new Array<Level>();
		json = new Json();
		read();
	}

	public void read() {
		String text = Gdx.files.internal(FILE_LOC).readString();
		JsonValue map = new JsonReader().parse(text);
		for (JsonValue entry = map.child; entry != null; entry = entry.next) {
			levels.add(json.fromJson(Level.class, entry.toString()));
		}

	}


	public Level getCurrLevel() {
		int levelIndex = GameService.instance.getSelectedLevelIndex();
		return levels.get(levelIndex);
	}

	public static class Level {

		private Array<Integer> colorsToFind;
		private int visibleFish;
		private float minSpeed;
		private float maxSpeed;
		private String name;
		private int targetFish;
		private int fishType;

		public Level() {

		}

		public Level(Array<Integer> colorsToFind, int numOfFish,
				float minSpeed, float maxSpeed, int targetFish, int fishType) {
			this.colorsToFind = colorsToFind;
			this.visibleFish = numOfFish;
			this.minSpeed = minSpeed;
			this.maxSpeed = maxSpeed;
			this.targetFish = targetFish;
			this.setFishType(fishType);
		}

		public Array<Integer> getColorsToFind() {
			return colorsToFind;
		}

		public void setColorsToFind(Array<Integer> colorsToFind) {
			this.colorsToFind = colorsToFind;
		}

		public int getVisibleFishOnTank() {
			return visibleFish;
		}

		public void setVisibleFishOnTank(int visibleFishOnTank) {
			this.visibleFish = visibleFishOnTank;
		}

		public float getMinSpeed() {
			return minSpeed;
		}

		public void setMinSpeed(float minSpeed) {
			this.minSpeed = minSpeed;
		}

		public float getMaxSpeed() {
			return maxSpeed;
		}

		public void setMaxSpeed(float maxSpeed) {
			this.maxSpeed = maxSpeed;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getTargetFish() {
			return targetFish;
		}

		public void setTargetFish(int targetFish) {
			this.targetFish = targetFish;
		}

		public int getFishType() {
			return fishType;
		}

		public void setFishType(int fishType) {
			this.fishType = fishType;
		}
		
		public String toString(){
			return "Name "+ getName() + "\n" +
				   "ColorsToFind "+ getColorsToFind() 
					;
		}
	}

}
