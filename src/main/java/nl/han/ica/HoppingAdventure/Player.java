package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

import java.util.List;

public class Player implements ICollidableWithGameObjects, ICollidableWithTiles {

	private Sound sound;
	private int size;


	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {

	}




	public Player(HoppingAdventure world) {

	}

	public void Bounce() {

	}

	public void keyPressed(char key) {

	}

	public void tileCollision() {

	}

	public void GameObjectCollision() {

	}

}
