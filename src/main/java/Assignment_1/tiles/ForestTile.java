package Assignment_1.tiles;

import javafx.scene.canvas.GraphicsContext;

public class ForestTile implements Tile {
    private final TileGraphic graphic = TileGraphicFactory.getGraphic("forest");
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "forest";
    }

    @Override
    public void action() {
        System.out.println("Going to the forest...");
    }

    @Override
    public void render(GraphicsContext gc, int x, int y, int tileSize) {
        gc.drawImage(graphic.getImage(), x * tileSize, y * tileSize, tileSize, tileSize);
    }
}