package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import processing.core.PGraphics;

import java.util.List;

public class Player extends GameObject implements ICollidableWithGameObjects, ICollidableWithTiles {
	private HoppingAdventure world;
	private Sound sound;
	private int size;

	public Player(int size, HoppingAdventure world) {
		this.size = size;
		this.world = world;
		setWidth(size);
		setHeight(size);
	}

	public void draw(PGraphics a) {
		a.ellipseMode(a.CORNER);
		a.fill(0, 255, 0, 0);
		a.ellipse(getX(), getY(), size, size);

	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {

	}



	public void Bounce() {

	}

	public void keyPressed(char key) {

	}

	public void tileCollision() {

	}

	public void GameObjectCollision() {

	}
	public void update(){

	}
}
