package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import processing.core.PGraphics;

import java.util.List;

public class Player extends GameObject {
    private HoppingAdventure world;
    private Sound sound;
    private int size;

    public Player(int size, HoppingAdventure world) {
        this.size = size;
        this.world = world;
    }

    public void draw(PGraphics a) {
        a.ellipseMode(a.CORNER);
        a.noStroke();
        a.fill(255, 255, 0);
        a.ellipse(getX(), getY(), size, size);

    }

//    @Override
//    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
//
//    }
//
//    @Override
//    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
//
//    }


    public void Bounce() {

    }



    @Override
    public void keyPressed(int keyCode, char key) {
        int speed = 10;
        if (key == 'a') {
            setDirectionSpeed(270, speed);
        }
        if (key == 'd') {
            setDirectionSpeed(90, speed);
        }

    }

    @Override
    public void keyReleased(int keyCode, char key) {
            setDirectionSpeed(0, 0);
        }
    public void tileCollision() {

    }

    public void GameObjectCollision() {

    }

    public void update() {
        if (getY() > 0){
            setGravity(1);
        }
        if (getX() <= 0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY() <= 0) {
            setySpeed(0);
            setY(0);
        }
        if (getX() >= world.getWidth() - size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
        }
        if (getY() >= world.getHeight() - size) {
            setySpeed(0);
            setY(world.getHeight() - size);
            setySpeed(-20);

        }
    }
}
