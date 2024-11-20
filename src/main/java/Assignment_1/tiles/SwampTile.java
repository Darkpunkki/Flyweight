package Assignment_1.tiles;

import javafx.scene.canvas.GraphicsContext;

public class SwampTile implements Tile {
    private final TileGraphic graphic = TileGraphicFactory.getGraphic("swamp");
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getType() {
        return "swamp";
    }

    @Override
    public void action() {
        System.out.println("Oops, there is a swamp here...");
    }

    @Override
    public void render(GraphicsContext gc, int x, int y, int tileSize) {
        gc.drawImage(graphic.getImage(), x * tileSize, y * tileSize, tileSize, tileSize);
    }
}