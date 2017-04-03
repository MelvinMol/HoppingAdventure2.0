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
import processing.core.PApplet;

public class HoppingAdventure extends GameEngine {

    private Player player;
    private BouncingEnemy bouncingEnemy;
    private WalkingEnemy walkingEnemy;
    private FlyingEnemy flyingEnemy;
    private Finish finish;
    private SpeedPowerUp speedPowerUp;
    private DartBlock dartBlock;
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
        addGameObject(player, 70, 800);
        walkingEnemy = new WalkingEnemy(this, 90);
        addGameObject(walkingEnemy, 400, 100);
        finish = new Finish(this, 50);
        addGameObject(finish, 850, 880);
        bouncingEnemy = new BouncingEnemy(this);
        addGameObject(bouncingEnemy, 600, 300);
        dartBlock = new DartBlock(this);
        addGameObject(dartBlock, 950, 650);
        flyingEnemy = new FlyingEnemy(this);
        addGameObject(flyingEnemy, 400, 400);
        speedPowerUp = new SpeedPowerUp(this);
        addGameObject(speedPowerUp, 400,650);

    }

    private void initializeTileMap() {
        Sprite blockSprite = new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/Block.png");
        Sprite jumpBlockSprite = new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/JumpBlock.png");
        Sprite spikeBlockSprite = new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/SpikeBlock.png");
        Sprite weakBlockSprite = new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/WeakBlock.png");
        Sprite invisibleBlockSprite = new Sprite("src/main/java/nl/han/ica/HoppingAdventure/Sprites/InvisibleBlock.png");

        TileType<Block> blockTileType = new TileType<>(Block.class, blockSprite);
        TileType<JumpBlock> jumpBlockTileType = new TileType<>(JumpBlock.class, jumpBlockSprite);
        TileType<SpikeBlock> spikeBlockType = new TileType<>(SpikeBlock.class, spikeBlockSprite);
        TileType<WeakBlock> weakBlockTileType = new TileType<>(WeakBlock.class, weakBlockSprite);
        TileType<InvisibleBlock> invisibleBlockTileType = new TileType<>(InvisibleBlock.class, invisibleBlockSprite);


        TileType[] tileTypes = {blockTileType, spikeBlockType, jumpBlockTileType, weakBlockTileType, invisibleBlockTileType};
        int tileSize = 50;
        int tilesMap[][] = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                { 0, -1, -1,  4, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1},
                { 0, -1, -1,  4, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1},
                { 0, -1, -1,  4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  4, -1, -1, -1, -1, -1, -1},
                { 0, -1, -1,  4,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1, -1,  -1, 4},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1, -1,  -1, 4},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4},
                { 0, -1,  1,  2,  0, -1, -1, -1, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                { 0,  2,  1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4},
                { 0, -1, -1, -1,  0,  3,  3,  0,  0,  3,  3,  3,  3,  3,  3,  1,  3,  3,  1,  0},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0},
                { 0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0},
                { 0, -1, -1,  2,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0},
                { 0,  0,  0,  0,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0,  0,  0,  0},
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
    }

    private void initializeSound() {
        deathSound = new Sound(this, "src/main/java/nl/han/ica/HoppingAdventure/Sounds/deathSound.mp3");

    }

    public void update() {
    }
}
