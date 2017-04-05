package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de dartblok
 */

public class DartBlock extends SpriteObject implements IAlarmListener {

    private HoppingAdventure world;
    private Alarm alarm;
    /**
     * Constructor
     * @param world Referentie naar de wereld.
     */
    public DartBlock(HoppingAdventure world) {
        super(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/DartBlock.png"));
        this.world = world;

        startAlarm();
    }

    /**
     * Als het alarm afgaat, dan maakt hij een dart aan en start hij het alarm opnieuw.
     * @param alarmName De naam van het alarm.
     */
    @Override
    public void triggerAlarm(String alarmName) {
        Dart d = new Dart(world);
        world.addGameObject(d, getX()-50, getY());
        startAlarm();
    }

    /**
     * Initialisatie van het alarm.
     */

    private void startAlarm() {
        alarm = new Alarm("DartAlarm", 3);
        alarm.addTarget(this);
        alarm.start();
    }

    /**
     * Verwijdert het alarm.
     */
    public void removeAlarm(){
        alarm.removeTarget(this);
    }

    @Override
    public void update() {
    }
}
