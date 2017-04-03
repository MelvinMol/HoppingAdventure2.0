package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import processing.core.PGraphics;

import java.util.List;


public class Finish extends SpriteObject {

	private HoppingAdventure world;
	private int size;

	public Finish(HoppingAdventure world, int size) {
		this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Finish.png"));
		this.world = world;
		this.size = size;

	}

	private Finish(Sprite sprite) {
		super(sprite);
	}


	@Override
	public void update() {

	}
}

