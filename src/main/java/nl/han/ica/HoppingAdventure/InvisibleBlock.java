package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de InvisibleBlock.
 */
public class InvisibleBlock extends Tile{

    private Sound sound;
    /**
     * Constructor
     * @param sprite De sprite die aan dit object gekoppeld moet worden
     */
    public InvisibleBlock(Sprite sprite) {
        super(sprite);
    }

}
