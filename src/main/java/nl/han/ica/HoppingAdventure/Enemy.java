package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;
import java.util.List;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de vijanden.
 */

public abstract class Enemy extends GameObject implements ICollidableWithTiles {
    public HoppingAdventure world;
    public int direction;
    public int size;
    public int r = 0;
    public int g = 0;
    public int b = 0;

    /**
     * Constructor
     * @param size de grootte van de vijanden.
     */
    public Enemy(int size){
        this.size = size;
        setHeight(size);
        setWidth(size);
    }

    /**
     * Tekent de vijanden.
     * @param p Voegt processing toe.
     */

    @Override
    public void draw(PGraphics p) {
        p.ellipseMode(p.CORNER);
        p.stroke(0);
        p.fill(r, g, b);
        p.ellipse(getX(), getY(), size, size);
    }

    /**
     * Zet de zwaartekracht aan op de vijanden en zet de richting waarop ze lopen en hun snelheid.
     */
    public void update() {
        setGravity(1);
        setDirectionSpeed(direction, 5);
    }

    public abstract void tileCollisionOccurred(List<CollidedTile> collidedTiles);

}
