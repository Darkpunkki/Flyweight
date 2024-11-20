package Assignment_1.tiles;

import javafx.scene.canvas.GraphicsContext;


public class BuildingTile implements Tile {
    private final TileGraphic graphic = TileGraphicFactory.getGraphic("building");
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getType() {
        return "building";
    }

    @Override
    public void action() {
        System.out.println("Entering a building...");
    }

    @Override
    public void render(GraphicsContext gc, int x, int y, int tileSize) {
        gc.drawImage(graphic.getImage(), x * tileSize, y * tileSize, tileSize, tileSize);
    }
}