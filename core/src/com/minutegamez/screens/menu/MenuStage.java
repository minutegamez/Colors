package com.minutegamez.screens.menu;

import static com.badlogic.gdx.math.Interpolation.bounceOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.scaleTo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.minutegamez.screens.menu.statpopup.StatPopup;
import com.minutegamez.utils.Constants;

public class MenuStage extends Stage {

	private static final float BUTTON_COUNT_X = 3;

	private Actor background;
	private Array<Tile> tiles;
	private Actor btnStat;

	private TileListener tileListener;
	private StatPopup popupStat;

	public MenuStage(StretchViewport stretchViewport, SpriteBatch batch) {
		super(stretchViewport, batch);

		tileListener = new TileListener();
		initPopups();
		initActors();
		addActors();
		setPosition();

	}

	private void initPopups() {
//		popupStat = new StatPopup(batc);
	}

	private void addActors() {
		addActor(background);
		addActor(btnStat);

		for (Actor actor : tiles) {
			addActor(actor);
		}

//		addActor(popupStat);
	}

	private void setPosition() {
		// equal divide
		// float offsetWidth = Constants.GUI_WIDTH / BUTTON_COUNT_X;
		// float posX = (offsetWidth / 2) - profileButton.get(0).getWidth() / 2;

		float btnWidth = tiles.get(0).getWidth();
		float btnHeight = tiles.get(0).getHeight();

		float centerX = Constants.GUI_WIDTH / 2;
		float centerY = Constants.GUI_HEIGHT / 2;

		float gapX = 20.0f;
		float gapY = 5.0f;

		float posX = centerX - btnWidth / 2 - gapX - btnWidth;
		float posY = centerY + gapY;

		for (int j = 0; j < Constants.MAX_TILES; j++) {
			Actor actor = tiles.get(j);

			actor.setPosition(posX, posY);
			posX += gapX + btnWidth;

			if (j + 1 == BUTTON_COUNT_X) {
				posX = centerX - btnWidth / 2 - gapX - btnWidth;
				posY = centerY - gapY - btnHeight;
			}
		}

		btnStat.setPosition(getWidth() - btnStat.getWidth(), 0);
	}

	public void startAnimation() {
		for (Actor actor : tiles) {
			actor.addAction(parallel(scaleTo(1, 1, .3f, bounceOut)));
		}
	}

	private void initActors() {
		background = new Background();
		btnStat = new StatButton();

		tiles = new Array<Tile>();
		for (int j = 0; j < Constants.MAX_TILES; j++) {
			Tile actor = new Tile(j);
			actor.addListener(tileListener);
			tiles.add(actor);
		}

		/***
		 * TODO: refactor?
		 */
		btnStat.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				popupStat.show();
			}

		});

	}

	class TileListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			super.clicked(event, x, y);
		}

	}

}
