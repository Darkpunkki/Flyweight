package Assignment_1.factory;

import Assignment_1.tiles.ForestTile;
import Assignment_1.tiles.SwampTile;
import Assignment_1.tiles.Tile;
import Assignment_1.tiles.WaterTile;
import Assignment_1.map.Map;

import java.util.Random;

public class WildernessMap extends Map {
    private final Random random;

    public WildernessMap(int width, int height) {
        super(width, height);
        this.random = new Random();
        generateMap();
    }

    @Override
    public Tile createTile() {
        int rand = random.nextInt(3);
        return switch (rand) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> throw new IllegalStateException("Unexpected value: " + rand);
        };
    }
}