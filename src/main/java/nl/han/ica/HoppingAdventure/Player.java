package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.List;

public class Player extends SpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {
    private HoppingAdventure world;
    private Sound deathSound;
    private int size;
    private boolean keya, keyd;

    public Player(HoppingAdventure world, Sound deathSound) {
        super(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Ball_2.png"));
        this.deathSound = deathSound;
        this.world = world;
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject a : collidedGameObjects) {

            if (a instanceof WalkingEnemy) {
                deathSound.play();
                setVisible(false);
            }
            if (a instanceof BouncingEnemy) {
                deathSound.play();
                setVisible(false);
            }
            if (a instanceof FlyingEnemy) {
                deathSound.play();
                setVisible(false);
            }
            if (a instanceof Finish) {
                deathSound.play();
                System.out.println("WOWOWOWOOWOWOWOWOWOW");
            }
        }
    }


    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        PVector TileLocation;

        for (CollidedTile t : collidedTiles) {

            if (t.theTile instanceof Block) {
                if (t.collisionSide == t.TOP) {
                    setySpeed(-15);
                }
                if (t.collisionSide == t.BOTTOM) {
                    setySpeed(2);
                }
                if (t.collisionSide == t.LEFT) {
                    setxSpeed(2);
                }
                if (t.collisionSide == t.BOTTOM) {
                    setySpeed(2);

                }
            }
            if (t.theTile instanceof SpikeBlock) {
                if (t.collisionSide == t.TOP) {
                    deathSound.play();
                    setVisible(false);
                }
                if (t.collisionSide == t.LEFT) {
                    setxSpeed(0);
                }
                if (t.collisionSide == t.BOTTOM) {
                    setxSpeed(0);
                }
                if (t.collisionSide == t.RIGHT) {
                    setxSpeed(0);
                }
            }
            if (t.theTile instanceof JumpBlock) {
                if (t.collisionSide == t.TOP) {
                    setySpeed(-25);
                }
                if (t.collisionSide == t.LEFT) {
                    setxSpeed(0);
                }
                if (t.collisionSide == t.BOTTOM) {
                    setxSpeed(0);
                }
                if (t.collisionSide == t.RIGHT) {
                    setxSpeed(0);
                }
            }
            if (t.theTile instanceof WeakBlock) {

                if (t.collisionSide == t.TOP) {
                    setySpeed(-20);
                }
                if (t.collisionSide == t.LEFT) {
                    setxSpeed(0);
                }
                if (t.collisionSide == t.BOTTOM) {
                    setxSpeed(0);
                }
                if (t.collisionSide == t.RIGHT) {
                    setxSpeed(0);
                }
                TileLocation = world.getTileMap().getTilePixelLocation(t.theTile);
                world.getTileMap().setTile((int) TileLocation.x / 50, (int) TileLocation.y / 50, -1);
            }
            if (t.theTile instanceof DartBlock) {
                if (t.collisionSide == t.TOP) {
                    setySpeed(-20);
                }
                if (t.collisionSide == t.LEFT) {
                    setxSpeed(0);
                }
                if (t.collisionSide == t.BOTTOM) {
                    setxSpeed(0);
                }
                if (t.collisionSide == t.RIGHT) {
                    setxSpeed(0);
                }
            }
        }
    }


    @Override
    public void keyPressed(int keyCode, char key) {
        if (key == 'a') {
            keya = true;
        }
        if (key == 'd') {
            keyd = true;
        }
    }

    @Override
    public void keyReleased(int keyCode, char key) {
        if (key == 'a') {
            keya = false;
        }
        if (key == 'd') {
            keyd = false;
        }

    }

    public void update() {
        setGravity(1);

        setxSpeed(0);
        if (keya) setxSpeed(-10);
        if (keyd) setxSpeed(10);

        if (getX() <= 0) {
            setxSpeed(0);
            setDirectionSpeed(90, 10);
        }
        if (getY() <= 20) {
            setySpeed(0);
        }
        if (getX() >= world.getWidth() - size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
            setDirectionSpeed(270, 10);
        }
        if (getY() >= world.getHeight() - size) {
            deathSound.play();
            setVisible(false);

        }
        if (!isVisible()) {
            setVisible(true);
            setX(70);
            setY(800);
        }
    }
}
