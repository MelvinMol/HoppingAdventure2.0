package nl.han.ica.HoppingAdventure;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor de finish.
 */

public class Finish extends SpriteObject {

	private HoppingAdventure world;
	private int size;

	/**
	 * Constructor
	 * @param world referentie naar de wereld
	 */
	public Finish(HoppingAdventure world) {
		this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Finish.png"));
		this.world = world;

	}
	/**
	 * @param sprite De sprite die aan dit object gekoppeld moet worden
	 */
	private Finish(Sprite sprite) {
		super(sprite);
	}


	@Override
	public void update() {

	}
}

