package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import processing.core.PGraphics;
import processing.core.PVector;
import java.util.List;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de speler.
 */

public class Player extends GameObject implements ICollidableWithTiles, ICollidableWithGameObjects, IAlarmListener {
    private HoppingAdventure world;
    private Sound deathSound;
    private int size;
    private int left = 'a';
    private int right = 'd';
    public static int speed = 10;
    private boolean keya, keyd;
    private Alarm alarm;

    /**
     * Constructor
     * @param world Referentie naar de wereld
     * @param deathSound Het geluid dat afgaat als de speler dood gaat
     * @param size De grootte van de speler.
     */
    public Player(HoppingAdventure world, Sound deathSound, int size) {
        this.deathSound = deathSound;
        this.world = world;
        this.size = size;
        setHeight(size);
        setWidth(size);
    }

    /**
     * Tekent de speler.
     * @param g PGraphics Zorgt ervoor dat processing werkt.
     */
    @Override
    public void draw(PGraphics g) {
        g.ellipseMode(g.CORNER);
        g.stroke(0);
        g.fill(255, 255, 0);
        g.ellipse(getX(), getY(), size, size);
    }

    /**
     * Doet iets als de speler een ander game object aanraakt.
     * @param collidedGameObjects De gameobjects van het spel
     */
    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        PGraphics g;
        for (GameObject a : collidedGameObjects) {

            if (a instanceof WalkingEnemy || a instanceof BouncingEnemy || a instanceof FlyingEnemy) {
                dead();
            }
            if (a instanceof Finish) {
          System.exit(0);



            }
            if (a instanceof Dart) {
            dead();
            }
            if (a instanceof SpeedPowerDown) {
                alarm = new Alarm("PowerupAlarm", 3);
                alarm.addTarget(this);
                alarm.start();
                SpeedPowerDown b = (SpeedPowerDown) a;
                b.DecreaseSpeed();
            }
        }
    }

    /**
     * Doet iets als het een tile aanraakt
     * @param collidedTiles Alle tiles in het spel
     */
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
                    dead();
                }

                if (ct.theTile instanceof WeakBlock) {
                    vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                    world.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
                    setySpeed(-15);
                }
            }
        }
    }

    /**
     * Zet een boolean aan als je op links of rechts drukt
     * @param key De knop op je toetsenbord die je indrukt
     */
    @Override
    public void keyPressed(int keyCode, char key) {
        if (key == left) {
            keya = true;
        }
        if (key == right) {
            keyd = true;
        }
    }
    /**
     * Zet een boolean uit als je links of rechts loslaat
     * @param key De knop op je toetsenbord die je indrukt
     */
    @Override
    public void keyReleased(int keyCode, char key) {
        if (key == left) {
            keya = false;
        }
        if (key == right) {
            keyd = false;
        }

    }

    /**
     * Zet de zwaartekracht
     * Zorg voor beweging
     * Zorgt voor de collision met de zijkanten van het scherm.
     */
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
            dead();
        }
    }

    /**
     * Als de speler in contact komt met iets dat hem zou moeten doden, dan word deze fucnctie uitgevoerd,
     * waardoor het spel gereset wordt.
     */
    private void dead(){
        deathSound.play();
        world.deleteAllGameOBjects();
        world.setupGame();
        world.removeDartBlockAlarm();
        if (speed != 10){
            speed = 10;
        }
    }

    /**
     * Als het alarm afgaat, dan wordt het alarm stopgezet en zet wordt de snelheid van de speler weer teruggezet.
     * @param alarmName naam van het Alarm
     */
    @Override
    public void triggerAlarm(String alarmName) {
        alarm.stop();
        speed = 10;
    }
}
