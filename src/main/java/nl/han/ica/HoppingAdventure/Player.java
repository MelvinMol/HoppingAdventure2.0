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

public class Player extends GameObject implements ICollidableWithTiles, ICollidableWithGameObjects {
    private HoppingAdventure world;
    private Sound deathSound;
    private int size;
    private int left = 'a';
    private int right = 'd';
    public static int speed = 10;
    private boolean keya, keyd;

    public Player(HoppingAdventure world, Sound deathSound, int size) {
        this.deathSound = deathSound;
        this.world = world;
        this.size = size;
        setHeight(size);
        setWidth(size);
    }

    @Override
    public void draw(PGraphics g) {
        g.ellipseMode(g.CORNER);
        g.stroke(0);
        g.fill(255, 255, 0);
        g.ellipse(getX(), getY(), size, size);
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject a : collidedGameObjects) {

            if (a instanceof WalkingEnemy || a instanceof BouncingEnemy || a instanceof FlyingEnemy) {
                world.deleteAllGameOBjects();
                world.setupGame();
            }
            if (a instanceof Finish) {
                world.deleteAllGameOBjects();
                world.setupGame();
                deathSound.play();
                System.out.println("WOWOWOWOOWOWOWOWOWOW");
            }
            if (a instanceof Dart) {
                deathSound.play();
                world.deleteAllGameOBjects();
                world.setupGame();
            }
            if (a instanceof SpeedPowerUp) {
                SpeedPowerUp b = (SpeedPowerUp) a;
                b.IncreaseSpeed();
            }
        }
    }


    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        PVector vector;

        for (CollidedTile ct : collidedTiles) {
            if (ct.theTile instanceof Block || ct.theTile instanceof JumpBlock || ct.theTile instanceof  SpikeBlock|| ct.theTile instanceof WeakBlock) {
                if (ct.collisionSide == ct.LEFT) {
                    vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                    setX(vector.x - width);
                }
                if (ct.collisionSide == ct.RIGHT) {
                    vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                    setX(vector.x + world.getTileMap().getTileSize());
                }

                if (ct.collisionSide == ct.BOTTOM) {
                    setySpeed(0);
                }
            }

            if (ct.collisionSide == ct.TOP) {
                if (ct.theTile instanceof Block) {
                    setySpeed(-15);
                }

                if (ct.theTile instanceof JumpBlock) {
                    setySpeed(-25);
                }

                if (ct.theTile instanceof SpikeBlock) {
                    deathSound.play();
                    world.deleteAllGameOBjects();
                    world.setupGame();
                }

                if (ct.theTile instanceof WeakBlock) {
                    vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                    world.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
                    setySpeed(-15);
                }
            }
        }
    }


    @Override
    public void keyPressed(int keyCode, char key) {
        if (key == left) {
            keya = true;
        }
        if (key == right) {
            keyd = true;
        }
    }

    @Override
    public void keyReleased(int keyCode, char key) {
        if (key == left) {
            keya = false;
        }
        if (key == right) {
            keyd = false;
        }

    }

    public void update() {
        setGravity(1);

        setxSpeed(0);
        if (keya) setxSpeed(-speed);
        if (keyd) setxSpeed(speed);

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
            world.deleteAllGameOBjects();
            world.setupGame();
        }
    }
}
