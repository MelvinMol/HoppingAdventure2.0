package nl.han.ica.HoppingAdventure;

import com.sun.prism.image.ViewPort;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

public class HoppingAdventure extends GameEngine {

    private Player player;
    private WalkingEnemy walkingEnemy;
    private Sound deathSound;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.HoppingAdventure.HoppingAdventure"});
    }

    @Override
    public void setupGame() {
        int worldWidth = 1000;
        int worldHeight = 1000;
        createView(worldWidth, worldHeight);
        initializeSound();
        initializeTileMap();
        createObjects();


    }


    private void createView(int screenWidth, int screenHeight) {
        View view = new View(screenWidth, screenHeight);
        view.setBackground(255, 255, 255);
        setView(view);
        size(screenWidth, screenHeight);
    }

    private void createObjects() {
        player = new Player(this, deathSound);
        addGameObject(player, 300, 200);
//        walkingEnemy = new WalkingEnemy(this, 50);
//        addGameObject(walkingEnemy, 600, 900);
    }

    public void initializeTileMap() {
        Sprite boardsSprite = new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Block.png");
        TileType<BoardsTile> boardTileType = new TileType<>(BoardsTile.class, boardsSprite);
        TileType[] tileTypes = {boardTileType};
        int tileSize = 100;
        int tilesMap[][] = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, 0, 0, -1},
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
    }

    public void initializeSound() {
        deathSound = new Sound(this, "src/main/java/nl/han/ica/HoppingAdventure/Sounds/deathSound.mp3");

    }


    public void timer() {

    }

    public void update() {
    }
}
