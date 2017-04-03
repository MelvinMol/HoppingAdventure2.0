package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import java.util.List;

public class Enemy extends SpriteObject {

    public int direction;

	public Enemy(Sprite sprite) {
		super(sprite);
	}

	public void update(){
		setGravity(1);
        setDirectionSpeed(direction, 5);
	}

	public void tileCollisionOccurred(List<CollidedTile> collidedTiles){

	}

}
