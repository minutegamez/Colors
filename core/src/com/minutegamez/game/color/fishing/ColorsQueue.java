package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.utils.Array;

public class ColorsQueue {
	private Array<Integer> targetColors;
	private int colorIndex;

	public ColorsQueue() {

	}

	public int getTargetColor() {
			return targetColors.get(colorIndex);
	}
	
	public void next(){
			colorIndex++;
	}

	public boolean isEmpty() {
		return (colorIndex  >= targetColors.size);
	}
	
	public void init(Array<Integer> targetColors){
		this.targetColors = targetColors;
		colorIndex = 0;
	}
}
