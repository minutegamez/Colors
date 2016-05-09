package com.minutegamez.framework.popup;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.minutegamez.framework.ImageGameObject;
import com.minutegamez.screens.profile.LevelRating;

public class LevelButton extends Button {

	private static final int MAX_STAR = 3;

	private Image imgNumber;
	private Array<Image> imgStars;
	private Image imgLock;
	private boolean isUnlocked = true;
	private Table table;

	public LevelButton(Skin skin, int index) {
		super(skin);
		table = new Table();
		imgStars = new Array<Image>();
		for (int j = 0; j < MAX_STAR; j++) {
			Image image = new CustomImage(skin.getRegion("star"));
			imgStars.add(image);
		}
		imgLock = new Image(skin.getRegion("lock"));
		imgNumber = new Image(skin.getRegion("num-" + index));
		table.setFillParent(true);
		table.add(imgLock).expand().center();
		 table.setDebug(true);
		setTouchable(Touchable.disabled);
		addActor(table);
	}

	public void unlock(LevelRating lvlRating) {
		table.clearChildren();

		setUnlocked(true);
		table.add(imgNumber).expandX().colspan(3).padTop(4);

		// below the number are the stars
		table.row().padBottom(3);


		int numOfStars = lvlRating.getNumOfStars();

		switch (numOfStars) {
		case 0: imgStars.get(0).setColor(Color.BLACK);
		case 1: imgStars.get(1).setColor(Color.BLACK);
		case 2: imgStars.get(2).setColor(Color.BLACK);
			break;
		default:
			break;
		}

		table.add(imgStars.get(0)).padLeft(5);
		table.add(imgStars.get(1)).padBottom(8);
		table.add(imgStars.get(2)).padRight(5);
	}

	public boolean isUnlocked() {
		return isUnlocked;
	}

	public void setUnlocked(boolean isUnlocked) {
		if (isUnlocked) {
			setTouchable(Touchable.enabled);
		}
		this.isUnlocked = isUnlocked;
	}

	public boolean isClicked(Actor target) {
		if (target.equals(imgNumber)) {
			return true;
		} else if (target.equals(this)) {
			return true;
		} else {
			for (Actor actor : imgStars)
				if (target.equals(actor)) {
					return true;
				}
		}
		return false;
	}

}
