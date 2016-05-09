package com.minutegamez.screens.profile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class GameService {

	public static final GameService instance = new GameService();
	private static final String FILE_LOC = ".profile.json";

	private Array<Profile> profiles;
	private Json json;
	private Profile selectedProfile;
	private int selectedLevelIndex;
	private int selectedGameIndex = Profile.GAME_FISHING;

	public int getSelectedLevelIndex() {
		return selectedLevelIndex;
	}
	
	public LevelRating getSelectedLevelRating(){
		GameLevelRatings gRating = getSelectedProfile().getGameRatings().get(selectedGameIndex);
		return gRating.getLevelRatings().get(selectedLevelIndex);
	}

	public void setSelectedLevelIndex(int selectedLevelIndex) {
		this.selectedLevelIndex = selectedLevelIndex;
	}

	public int getSelectedGameIndex() {
		return selectedGameIndex;
	}

	public void setSelectedGameIndex(int selectedGameIndex) {
		this.selectedGameIndex = selectedGameIndex;
	}

	private GameService() {
		json = new Json();
		profiles = new Array<Profile>();
		retrieveProfiles();
	}

	public Array<Profile> getProfiles() {
		return profiles;
	}

	public void persist() {
		Gdx.files.local(FILE_LOC).writeString(json.toJson(profiles), false);
	}

	public void retrieveProfiles() {
		try {
			String text = Gdx.files.local(FILE_LOC).readString();
			JsonValue map = new JsonReader().parse(text);
			for (JsonValue entry = map.child; entry != null; entry = entry.next) {
				profiles.add(json.fromJson(Profile.class, entry.toString()));
			}
		} catch (Exception e) {
			// if error in reading create default
			e.printStackTrace();
			profiles.add(Profile.create());
			persist();
			System.out.println("created newproifle");
		}
		
//		//temp delete profiles
//		profiles.clear();
//		persist();
		
		// System.out.println(json.prettyPrint(profiles));
	}

	public Profile getSelectedProfile() {
		return getProfiles().get(0);
		// return selectedProfile;
	}

	public void setSelectedProfile(Profile selectedProfile) {
		this.selectedProfile = selectedProfile;
	}

}
