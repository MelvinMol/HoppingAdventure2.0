package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import processing.core.PGraphics;

import java.util.List;

public class FlyingEnemy extends SpriteObject implements Enemy {

	HoppingAdventure world;

	public FlyingEnemy(HoppingAdventure world){
		this(new Sprite("D:\\School\\HoppingAdventure\\OOPD GAME ENGINE\\src\\main\\java\\nl\\han\\ica\\HoppingAdventure"));
		this.world = world;
	}

	private FlyingEnemy(Sprite sprite) {
	super(sprite);
	}

	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {

	}

	public void Move() {

	}

public void draw(PGraphics a){

}

	@Override
	public void update() {

	}


}
