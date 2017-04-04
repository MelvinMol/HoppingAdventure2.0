package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de SpeedPowerUp.
 */

    public class SpeedPowerUp extends SpriteObject{

        HoppingAdventure world;

    /**
     * Constructor
     * @param world Referentie naar de wereld.
     */
        public SpeedPowerUp(HoppingAdventure world) {
            this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/p.png"));
            this.world = world;
        }

    /**
     * @param sprite De sprite die aan dit object gekoppeld moet worden
     */
        private SpeedPowerUp(Sprite sprite) {
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
    }
