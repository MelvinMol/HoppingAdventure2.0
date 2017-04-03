package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import processing.core.PGraphics;

    public class SpeedPowerUp extends SpriteObject{

        HoppingAdventure world;

        public SpeedPowerUp(HoppingAdventure world) {
            this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/p.png"));
            this.world = world;
        }

        private SpeedPowerUp(Sprite sprite) {
            super(sprite);
        }

        public void IncreaseSpeed() {
            Player.speed = 5;
            world.deleteGameObject(this);
        }

        @Override
        public void update() {

        }
    }
