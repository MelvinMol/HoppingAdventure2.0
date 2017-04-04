package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import processing.core.PVector;

import java.util.List;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de lopende vijand.
 */
public class WalkingEnemy extends Enemy {

    private HoppingAdventure world;
    /**
     * Constructor
     * @param world Referentie naar de wereld.
     */
    public WalkingEnemy(HoppingAdventure world) {
        super(30);
        this.world = world;
        g = 255;

    }

    /**
     * Verandert de richting van de vijand als hij tegen een tile aankomt.
     * @param collidedTiles Dit zijn alle tiles in de wereld.
     */
    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        PVector vector;

        for (CollidedTile t : collidedTiles) {

            if (t.theTile instanceof Block) {
                if (t.collisionSide == t.TOP) {
                    vector = world.getTileMap().getTilePixelLocation(t.theTile);
                    setY(vector.y - getHeight());
                }
                if (t.collisionSide == t.LEFT) {
                    direction = 270;
                }
                if (t.collisionSide == t.RIGHT) {
                    direction = 90;
                }
            }
            if(t.theTile instanceof InvisibleBlock){
                if(t.collisionSide == t.LEFT){
                    direction = 270;
                }
                if(t.collisionSide == t.RIGHT){
                    direction = 90;
                }
            }
        }
    }
}

