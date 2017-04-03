package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import java.util.List;

public class FlyingEnemy extends SpriteObject implements Enemy, ICollidableWithTiles {

    HoppingAdventure world;
    int direction;

    public FlyingEnemy(HoppingAdventure world) {
        this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Ball_2.png"));
        this.world = world;
    }

    private FlyingEnemy(Sprite sprite) {
        super(sprite);
    }

    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        for (CollidedTile t : collidedTiles) {
        if (t.theTile instanceof Block) {
            if (t.collisionSide == t.TOP) {
                direction = 0;
            }
            if (t.collisionSide == t.BOTTOM) {
                direction = 180;
            }
        }
        if (t.theTile instanceof InvisibleBlock) {
            if (t.collisionSide == t.TOP) {
                direction = 0;
            }
            if (t.collisionSide == t.BOTTOM) {
                direction = 180;;
            }
        }
    }
}

    @Override
    public void update() {
    setDirectionSpeed(direction, 5);
    }


}
