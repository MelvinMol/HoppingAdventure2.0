package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.List;


public class WalkingEnemy extends Enemy {

    private HoppingAdventure world;

    public WalkingEnemy(HoppingAdventure world) {
        super(30);
        this.world = world;
        g = 255;

    }


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

