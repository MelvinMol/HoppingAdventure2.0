package nl.han.ica.HoppingAdventure;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.Tile;
import java.util.List;

/**
 * @author Melvin MoL en Jesse Arends
 * De klasse voor het dart projectiel.
 */

public class Dart extends SpriteObject implements ICollidableWithTiles{

    private HoppingAdventure world;

    /**
     * Constructor
     * @param world Referentie naar de wereld.
     */
    public Dart(HoppingAdventure world) {
        this(new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Dart.png"));
        this.world = world;

    }

    /**
     * @param sprite De sprite die aan dit object gekoppeld moet worden
     */
    private Dart(Sprite sprite) {
        super(sprite);
        setxSpeed(-5);
    }

    /**
     * Zorgt ervoor dat zodra de dart uit de wereld is, hij verdwijnt.
      */

    @Override
    public void update() {
        if (getX()<=0 - getWidth()) {
            world.deleteGameObject(this);
        }
    }

    /**
     * Dit zorgt ervoor dat zodra de dart een tile aanraakt, hij verwijdert wordt.
     * @param collidedTiles dit zijn alle tiles in de wereld.
     */
    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        for (CollidedTile t : collidedTiles){
            if(t.theTile instanceof Tile){
                world.deleteGameObject(this);
            }
        }
    }
}