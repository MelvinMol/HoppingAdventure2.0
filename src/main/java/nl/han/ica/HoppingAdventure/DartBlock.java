package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.waterworld.WaterWorld;
import processing.core.PGraphics;

public class DartBlock extends SpriteObject implements IAlarmListener {

    private HoppingAdventure world;

    public DartBlock(HoppingAdventure world) {
        super(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/DartBlock.png"));
        this.world = world;
        startAlarm();
    }

    @Override
    public void triggerAlarm(String alarmName) {
        Dart d = new Dart(world);
        world.addGameObject(d, getX()-50, getY());
        startAlarm();
    }

    private void startAlarm() {
        Alarm alarm = new Alarm("DartAlarm", 1.5);
        alarm.addTarget(this);
        alarm.start();
    }

    @Override
    public void update() {
    }

}
