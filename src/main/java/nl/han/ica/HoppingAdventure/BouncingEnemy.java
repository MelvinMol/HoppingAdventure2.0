package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import java.util.List;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de springende vijand
 */

public class BouncingEnemy extends Enemy {

    private HoppingAdventure world;

    /**
     *Constructor
     * @param world dit is een referencie naar de wereld.
     */
    public BouncingEnemy(HoppingAdventure world) {
        super(30);
        this.world = world;
        b = 255;
    }
    /**
     * Verandert de kant die de bouncing enemy op gaat als hij in contact komt met een tile.
     * @param collidedTiles dit zijn alle tiles in de tilemap
     */


    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        for (CollidedTile t : collidedTiles) {

            if (t.theTile instanceof Block) {
                if (t.collisionSide == t.TOP) {
                    setySpeed(-10);
                }
                if (t.collisionSide == t.BOTTOM) {
                    setySpeed(2);
                }
            }
            if (t.theTile instanceof InvisibleBlock) {
                if (t.collisionSide == t.TOP) {
                    setySpeed(-10);
                }
                if (t.collisionSide == t.BOTTOM) {
                    setySpeed(2);
                }
                if (t.collisionSide == t.LEFT) {
                    setDirection(270);
                }
                if (t.collisionSide == t.RIGHT) {
                    setDirection(90);

                }
            }
        }
    }

    /**
     * Zer de zwaartekracht op 1 en de snelheid op 5.
     */
    @Override
    public void update() {
        setSpeed(5);
        setGravity(1);
    }
}
