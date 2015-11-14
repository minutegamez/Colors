package com.minutegamez.framework.popup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class InstructionService {

	private Skin skin = PopupAsset.instance.tutorialFishingSkin;
	private static final String FILE_LOC = "data/tutorial/fishing.json";

	public InstructionService() {

	}

	public Array<Instruction> getInstructions() {
		Array<Instruction> instructions = new Array<Instruction>();
		Array<AtlasRegion> images = skin.getAtlas().findRegions("tutorial");
		Array<String> texts = retrieveTexts();
		for (int j = 0; j < images.size; j++) {
			instructions.add(new Instruction(images.get(j), texts.get(j)));
		}

		return instructions;
	}

	private Array<String> retrieveTexts() {
		Array<String> texts = new Array<String>();
		try {
			Json json = new Json();
			String text = Gdx.files.internal(FILE_LOC).readString();
			JsonValue map = new JsonReader().parse(text);
			for (JsonValue entry = map.child; entry != null; entry = entry.next) {
				texts.add(json.fromJson(String.class, entry.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return texts;
	}
}
