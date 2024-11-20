package Assignment_1.map;

import Assignment_1.tiles.Tile;
import javafx.scene.canvas.GraphicsContext;

abstract public class Map {
    public Tile[][] tiles;
    protected int width;
    protected int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
    }

    public abstract Tile createTile();

    public void display() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    public void render(GraphicsContext gc, int tileSize) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j].render(gc, i, j, tileSize);
            }
        }
    }

    protected void generateMap() {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile tile = createTile();
                tiles[i][j] = tile;

            }
        }
    }

}

