package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.List;

public class Player extends SpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {
    private HoppingAdventure world;
    private Sound deathSound;
    private int size;

    public Player(HoppingAdventure world, Sound deathSound) {
        super(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Ball.png"));
        this.deathSound = deathSound;
        this.world = world;
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject a : collidedGameObjects) {
            System.out.println("hoi");
            if (a instanceof WalkingEnemy) {
                deathSound.play();
                setVisible(false);
            }
        }
    }


    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        for (CollidedTile t : collidedTiles) {
            if (t.theTile instanceof BoardsTile) {
                if (t.collisionSide == t.TOP) {
                    setySpeed(-20);
                }
            }
        }
    }

    @Override
    public void keyPressed(int keyCode, char key) {
        int speed = 10;
        if (key == 'a' && getY() > 100) {
            setDirectionSpeed(270, speed);
        }
        if (key == 'd' && getY() > 100) {
            setDirectionSpeed(90, speed);
        }
    }

    @Override
    public void keyReleased(int keyCode, char key) {
        setDirectionSpeed(0, 0);
    }

    public void update() {
            setGravity(1);

        if (getX() <= 0) {
            setxSpeed(0);
            setDirectionSpeed(90, 10);
        }
        if (getY() <= 0) {
            setySpeed(0);
        }
        if (getX() >= world.getWidth() - size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
            setDirectionSpeed(270, 10);
        }
        if (getY() >= world.getHeight() - size) {
            setySpeed(0);
            setY(world.getHeight() - size);
            setySpeed(-20);

        }
        if (!isVisible()) {
            setVisible(true);
            setX(300);
            setY(200);
        }
    }
}
