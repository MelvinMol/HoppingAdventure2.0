package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import processing.core.PGraphics;

import java.util.List;

public class BouncingEnemy extends Enemy {

    private HoppingAdventure world;

    public BouncingEnemy(HoppingAdventure world) {
        super(30);
        this.world = world;
        b = 255;
    }
    /**
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

    @Override
    public void update() {
        setSpeed(5);
        setGravity(1);
    }
}
