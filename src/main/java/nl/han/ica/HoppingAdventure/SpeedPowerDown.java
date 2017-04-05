package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de SpeedPowerDown.
 */

    public class SpeedPowerDown extends SpriteObject implements IAlarmListener{

        private HoppingAdventure world;

    /**
     * Constructor
     * @param world Referentie naar de wereld.
     */
        public SpeedPowerDown(HoppingAdventure world) {
            this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/SpeedPowerDown.png"));
            this.world = world;
        }

    /**
     * @param sprite De sprite die aan dit object gekoppeld moet worden
     */
        private SpeedPowerDown(Sprite sprite) {
            super(sprite);
        }

    /**
     * Verlaagt de snelheid van de speler.
     */
    public void DecreaseSpeed() {
//            Player.left = 'd';
//            Player.right = 'a';
                Player.speed = 5;
                world.deleteGameObject(this);
        }
        @Override
        public void update() {

        }

    @Override
    public void triggerAlarm(String alarmName) {
    }


}
