package com.minutegamez.screens.profile;

import com.badlogic.gdx.utils.Array;
import com.minutegamez.utils.Constants;

public class Score {
	private int index;
	private Array<Integer> difficult;
	private float accuracy;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Array<Integer> getDifficult() {
		return difficult;
	}

	public void setDifficult(Array<Integer> difficult) {
		this.difficult = difficult;
	}

	public float getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public static Score create() {
		Score score = new Score();
		score.setIndex(0);
		score.setAccuracy(0.0f);
		Array<Integer> difficult = new Array<Integer>();
		for (int j = 0; j < Constants.MAX_COLOR; j++) {
			difficult.add(new Integer(0));
		}
		score.setDifficult(difficult);
		return score;
	}
}
