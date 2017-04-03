package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import java.util.List;

public abstract class Enemy extends SpriteObject {

	private HoppingAdventure world;

	public Enemy(Sprite sprite) {
		super(sprite);
	}

	public abstract void update();

	public abstract void tileCollisionOccurred(List<CollidedTile> collidedTiles);

}