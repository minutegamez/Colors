package com.minutegamez.framework.popup;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Back;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.minutegamez.framework.ActorAccessor;
import com.minutegamez.framework.PopupStage;
import com.minutegamez.utils.Constants;

public class TutorialStage extends PopupStage {

	public static final int RESPONSE_PLAY = 100;

	private Skin skin;

	private Button btnNext;
	private Button btnPrevious;
	private Button btnPlay;
	private int instructionIndex = 0;
	private Table instructionTable;
	private Instruction currInstruction;
	private Array<Instruction> instructions;

	private Table table;

	public TutorialStage(Batch batch, TweenManager manager,
			InstructionService instructionService) {
		super(batch, manager);
		skin = PopupAsset.instance.tutorialSkin;
		listener = new ButtonListener();
		instructions = instructionService.getInstructions();

		initGameObjects();
		setSizes();
		setPositions();
		addListeners();

		addActor(table);
		setDebugAll(true);
	}

	private void addListeners() {
		btnNext.addListener(listener);
		btnPrevious.addListener(listener);
		btnPlay.addListener(listener);
	}

	private void initGameObjects() {
		table = new Table();

		btnNext = new Button(skin, "arrow");
		btnPrevious = new Button(skin, "arrow");
		btnPlay = new Button(skin, "play");
		instructionTable = new Table();

		resetInstructionTable();

		table.setBackground(skin.getDrawable("background"));
	}

	private void setPositions() {
		Constants.setPosToCenter(table);
		table.setTransform(true);
		table.add(instructionTable).colspan(3);
		table.row();
		table.left().bottom();
		table.add(btnPrevious).expandX().align(Align.left);
		table.add(btnPlay).expandX().align(Align.center);
		table.add(btnNext).expandX().align(Align.right);

		btnPrevious.setTransform(true);
		Constants.setOriginToCenter(btnPrevious);
		btnPrevious.setRotation(180);
	}

	private void setSizes() {
		table.setSize(537, 384);
		Constants.setOriginToCenter(table);
	}

	private void next() {
		if (instructions.size > instructionIndex + 1) {
			instructionIndex++;
			resetInstructionTable();
		}
	}

	private void resetInstructionTable() {
		instructionTable.clearChildren();

		currInstruction = instructions.get(instructionIndex);

		instructionTable.add(currInstruction.getImage());
		instructionTable.row();
		instructionTable.add(currInstruction.getLabel());

	}

	private void previous() {
		if (instructionIndex > 0) {
			instructionIndex--;
			resetInstructionTable();
		}
	}

	class ButtonListener extends ClickListener {

		@Override
		public void clicked(InputEvent event, float x, float y) {
			if (getState() == STATE_ANIMATION_FINISHED) {
				if (event.getTarget().equals(btnNext)) {
					next();
				} else if (event.getTarget().equals(btnPrevious)) {
					previous();
				} else if (event.getTarget().equals(btnPlay)) {
					setResponse(RESPONSE_PLAY);
				}
			}
			super.clicked(event, x, y);
		}
	}

	@Override
	public void setResponse(int response) {
		this.response = response;
		switch (getResponse()) {
		case RESPONSE_PLAY:
			hide();
			break;
		}
	}

	@Override
	public void showEntranceAnimation() {
		table.setScale(.5f, .5f);
		Tween.to(table, ActorAccessor.SCALE_XY, .5f).target(1f, 1f)
				.ease(Back.OUT).setCallback(animationCallback).start(manager);
	}

	@Override
	public void showExitAnimation() {
		Tween.to(table, ActorAccessor.SCALE_XY, .5f).target(0f, 0f)
				.ease(Back.IN).setCallback(animationCallback).start(manager);
	}

}
