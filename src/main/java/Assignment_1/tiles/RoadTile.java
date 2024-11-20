package Assignment_1.tiles;

import javafx.scene.canvas.GraphicsContext;

public class RoadTile implements Tile {
    private final TileGraphic graphic = TileGraphicFactory.getGraphic("road");
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getType() {
        return "road";
    }

    @Override
    public void action() {
        System.out.println("Driving on the road...");
    }

    @Override
    public void render(GraphicsContext gc, int x, int y, int tileSize) {
        gc.drawImage(graphic.getImage(), x * tileSize, y * tileSize, tileSize, tileSize);
    }
}

