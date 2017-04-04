package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de Jumpblock.
 */
public class JumpBlock extends Tile {

	private Sound sound;
	/**
	 * Constructor
	 * @param sprite De sprite die aan dit object gekoppeld moet worden
	 */
	public JumpBlock(Sprite sprite) {
		super(sprite);
	}

}
