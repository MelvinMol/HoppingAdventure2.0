package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.List;


public class Dart extends SpriteObject implements ICollidableWithTiles{

    private HoppingAdventure world;


    public Dart(HoppingAdventure world) {
        this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Dart.png"));
        this.world = world;

    }

    private Dart(Sprite sprite) {
        super(sprite);
        setxSpeed(-5);
    }


    @Override
    public void update() {
        if (getX()<=0 - getWidth()) {
            world.deleteGameObject(this);
        }
    }


    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        for (CollidedTile t : collidedTiles){
            if(t.theTile instanceof Tile){
                world.deleteGameObject(this);
            }
        }
    }
}