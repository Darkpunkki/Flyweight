package Assignment_1.tiles;

import javafx.scene.canvas.GraphicsContext;

public class WaterTile implements Tile {
    private final TileGraphic graphic = TileGraphicFactory.getGraphic("water");
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "water";
    }

    @Override
    public void action() {
        System.out.println("Swimming in the Water...");
    }

    @Override
    public void render(GraphicsContext gc, int x, int y, int tileSize) {
        gc.drawImage(graphic.getImage(), x * tileSize, y * tileSize, tileSize, tileSize);
    }
}