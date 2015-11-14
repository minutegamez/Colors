package com.minutegamez.test.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class Packer {

	static final String POPUP_PAUSE_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Pause\\Input";
	static final String POPUP_PAUSE_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Pause\\Output";;
	static final String POPUP_PAUSE_NAME = "popup_pause.atlas";

	static final String POPUP_RUNNING_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Running\\Input";
	static final String POPUP_RUNNING_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Running\\Output";;
	static final String POPUP_RUNNING_NAME = "popup_running.atlas";

	static final String POPUP_READY_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Ready\\Input";
	static final String POPUP_READY_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Ready\\Output";;
	static final String POPUP_READY_NAME = "popup_ready.atlas";

	static final String POPUP_LEVEL_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Level\\Input";
	static final String POPUP_LEVEL_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Level\\Output";;
	static final String POPUP_LEVEL_NAME = "popup_level.atlas";

	static final String PROFILE_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Profile\\Input";
	static final String PROFILE_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Profile\\Output";;
	static final String PROFILE_NAME = "profile.atlas";

	static final String NEW_PROFILE_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Profile\\New\\Input";
	static final String NEW_PROFILE_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Profile\\New\\Output";;
	static final String NEW_PROFILE_NAME = "new_profile.atlas";

	
	static final String POPUP_TUTORIAL_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Tutorial\\Input";
	static final String POPUP_TUTORIAL_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\Tutorial\\Output";;
	static final String POPUP_TUTORIAL_NAME = "popup_tutorial.atlas";

	static final String FISHING_TUTORIAL_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Game\\Fishing\\Tutorial\\Input";
	static final String FISHING_TUTORIAL_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Game\\Fishing\\Tutorial\\Output";
	static final String FISHING_TUTORIAL_NAME = "tutorial_fishing.atlas";

	static final String FISHING_GAME_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Game\\Fishing\\Game\\Input";
	static final String FISHING_GAME_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Game\\Fishing\\Game\\Output";
	static final String FISHING_GAME_NAME = "fishing.atlas";

	static final String FISHING_BACKGROUND_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Game\\Fishing\\Background\\Input";
	static final String FISHING_BACKGROUND_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Game\\Fishing\\Background\\Output";
	static final String FISHING_BACKGROUNDD_NAME = "fishing_background.atlas";

	
	static final String POPUP_LEVEL_END_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\LevelEnd\\Input";
	static final String POPUP_LEVEL_END_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Popup\\LevelEnd\\Output";;
	static final String POPUP_LEVEL_END_NAME = "popup_level_end.atlas";

	public static void main(String[] args) {
		TexturePacker.process(FISHING_GAME_INPUT, FISHING_GAME_OUTPUT,
				FISHING_GAME_NAME);
	}
}
