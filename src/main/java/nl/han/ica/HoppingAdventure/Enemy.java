package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;

import java.util.List;

public interface Enemy {

	public void update();

	public void tileCollisionOccurred(List<CollidedTile> collidedTiles);

}
