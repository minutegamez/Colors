package com.minutegamez.screens.profile.mainstage.model;

public class Profile {

	private String name;
	private Gender gender;

	public Profile() {

	}

	public Profile(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
