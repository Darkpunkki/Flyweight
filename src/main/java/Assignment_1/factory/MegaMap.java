package Assignment_1.factory;

import Assignment_1.map.Map;
import Assignment_1.tiles.*;

import java.util.Random;

public class MegaMap extends Map {
    private final Random random;

    public MegaMap(int width, int height) {
        super(width, height);
        this.random = new Random();
        generateMap();
    }

    public Tile createTile() {
        int rand = random.nextInt(5);
        return switch (rand) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            case 2 -> new BuildingTile();
            case 3 -> new WaterTile();
            case 4 -> new SwampTile();
            default -> throw new IllegalStateException("Unexpected value: " + rand);
        };
    }
}
