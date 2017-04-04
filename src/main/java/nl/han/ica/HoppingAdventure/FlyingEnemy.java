package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import java.util.List;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de vliegende vijand..
 */

public class FlyingEnemy extends Enemy implements ICollidableWithTiles {

    HoppingAdventure world;

    /**
     * Constructor
     * @param world referentie naar de wereld.
     */
    public FlyingEnemy(HoppingAdventure world) {
        super(30);
        this.world = world;
        r = 255;
    }

    /**
     * Verandert de richting van de enemy als hij tegen een tile aankomt.
     * @param collidedTiles dit zijn alle tiles in de wereld.
     */
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        for (CollidedTile t : collidedTiles) {
                if (t.collisionSide == t.TOP) {
                    direction = 0;
                }
                if (t.collisionSide == t.BOTTOM) {
                    direction = 180;
                }
            }
        }
    }

