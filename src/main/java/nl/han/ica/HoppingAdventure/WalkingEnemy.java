package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import processing.core.PGraphics;

import java.util.List;


public class WalkingEnemy extends SpriteObject implements Enemy {

	private HoppingAdventure world;
	private int size;

	public WalkingEnemy(HoppingAdventure world, int size) {
		this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Enemy1.png"));
		this.world = world;
		this.size = size;

	}

	private WalkingEnemy(Sprite sprite) {
		super(sprite);
		setxSpeed(5);
	}


	@Override
	public void tileCollision() {

	}


	@Override
	public void update() {
		if (getX() <= 0) {
			setDirection(90);
		}
		if (getX() >= world.getWidth()- 112) {
			setDirection(270);
		}
	}
}

