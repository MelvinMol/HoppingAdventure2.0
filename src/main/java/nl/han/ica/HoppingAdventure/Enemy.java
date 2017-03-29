package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;

public abstract class Enemy implements ICollidableWithTiles {

	public void update() {

	}

	public void tileCollision() {

	}

	public abstract void Move();

}
