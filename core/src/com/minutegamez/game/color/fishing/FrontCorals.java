package com.minutegamez.game.color.fishing;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.minutegamez.framework.ImageGameObject;

public class FrontCorals extends ImageGameObject{
		private ImageGameObject greenCoral;
		private ImageGameObject blueCoral;
		private ImageGameObject yellowCoral;
		
		public FrontCorals(){
			greenCoral = new ImageGameObject(ColorFishingAsset.instance.gameAsset.greenCoral);
			blueCoral = new ImageGameObject(ColorFishingAsset.instance.gameAsset.blueCoral);
			yellowCoral = new ImageGameObject(ColorFishingAsset.instance.gameAsset.yellowCoral);
		
			greenCoral.setPosition(.3f, .2f);
			blueCoral.setPosition(1.5f, .2f);
			yellowCoral.setPosition(11.3f, .5f);
		}


		@Override
		public void draw(Batch batch, float parentAlpha) {
			greenCoral.draw(batch, parentAlpha);
			blueCoral.draw(batch, parentAlpha);
			yellowCoral.draw(batch, parentAlpha);
		}
}
