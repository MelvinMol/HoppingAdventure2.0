package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import processing.core.PGraphics;

import java.util.List;

public abstract class Enemy extends GameObject implements ICollidableWithTiles {
    public HoppingAdventure world;
    public int direction;
    public int size;
    public int r = 0;
    public int g = 0;
    public int b = 0;

    public Enemy(int size){
        this.size = size;
        setHeight(size);
        setWidth(size);
    }

    @Override
    public void draw(PGraphics p) {
        p.ellipseMode(p.CORNER);
        p.stroke(0);
        p.fill(r, g, b);
        p.ellipse(getX(), getY(), size, size);
    }

    public void update() {
        setGravity(1);
        setDirectionSpeed(direction, 5);
    }

    public abstract void tileCollisionOccurred(List<CollidedTile> collidedTiles);

}
