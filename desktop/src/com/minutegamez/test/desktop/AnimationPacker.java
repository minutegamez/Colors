package com.minutegamez.test.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class AnimationPacker {

	static final String POPUP_PAUSE_INPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Animation\\Monkey\\Input";
	static final String POPUP_PAUSE_OUTPUT = "C:\\Users\\jaime\\Desktop\\Thesis\\Assets\\Raw\\Animation\\Monkey\\Output";;
	static final String POPUP_PAUSE_NAME = "animation.atlas";

	public static void main(String[] args) {
		TexturePacker.process(POPUP_PAUSE_INPUT, POPUP_PAUSE_OUTPUT,
				POPUP_PAUSE_NAME);
	}
}
