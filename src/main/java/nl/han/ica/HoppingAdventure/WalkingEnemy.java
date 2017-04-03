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


public class WalkingEnemy extends SpriteObject implements Enemy, ICollidableWithTiles {

    private HoppingAdventure world;
    private int size;
    private int direction;

    public WalkingEnemy(HoppingAdventure world, int size, int direction) {
        this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Ball_2.png"));
        this.direction = direction;
        this.world = world;
        this.size = size;

    }

    private WalkingEnemy(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        PVector TileLocation;

        for (CollidedTile t : collidedTiles) {

            if (t.theTile instanceof Block) {
                if (t.collisionSide == t.TOP) {
                    TileLocation = world.getTileMap().getTilePixelLocation(t.theTile);
                    setY(TileLocation.y - getHeight());
                }
                if (t.collisionSide == t.BOTTOM) {
                    setySpeed(2);
                }
                if (t.collisionSide == t.LEFT) {
                    direction = 90;
                }
                if (t.collisionSide == t.RIGHT) {
                    direction = 270;
                }
            }
            if(t.theTile instanceof InvisibleBlock){
                if(t.collisionSide == t.LEFT){
                    direction = 90;
                }
                if(t.collisionSide == t.RIGHT){
                    direction = 270;
                }
            }
        }
    }

    @Override
    public void update() {
        setDirectionSpeed(direction, 2);
        setGravity(1);
    }
}

