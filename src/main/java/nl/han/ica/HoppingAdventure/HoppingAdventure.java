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


@SuppressWarnings("serial")
public class HoppingAdventure extends GameEngine {

	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.HoppingAdventure.HoppingAdventure"});
	}

@Override
	public void setupGame() {
		int worldWidth = 500;
		int worldHeight = 500;
		createView(worldWidth, worldHeight);

	}

	private void createView(int screenWidth, int screenHeight) {
View view = new View(screenWidth, screenHeight);
view.setBackground(255, 255, 255);
setView(view);
size(screenWidth, screenHeight);
	}

	public void createObjects() {

	}

	public void initializeTileMap() {

	}

	public void initializeSound() {

	}

	public void timer() {

	}

	public void update() {
	}
}