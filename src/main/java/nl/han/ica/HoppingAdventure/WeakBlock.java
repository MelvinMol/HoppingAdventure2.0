package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de weakblock.
 */
public class WeakBlock extends Tile{

    private Sound sound;
    /**
     * Constructor
     * @param sprite De sprite die aan dit object gekoppeld moet worden
     */
    public WeakBlock(Sprite sprite) {
        super(sprite);
    }

}
