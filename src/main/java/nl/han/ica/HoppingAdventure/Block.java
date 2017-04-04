package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de block tile
 */
public class Block extends Tile {

    private Sound sound;

    /**
     * Constructor
     * @param sprite Voegt een sprite toe aan het object.
     */

    public Block(Sprite sprite) {
        super(sprite);
    }

}


