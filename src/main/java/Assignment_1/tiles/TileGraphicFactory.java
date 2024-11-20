package Assignment_1.tiles;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, TileGraphic> graphics = new HashMap<>();

    public static TileGraphic getGraphic(String type) {
        return graphics.computeIfAbsent(type, t -> {
            System.out.println("Creating new TileGraphic for type: " + t);
            String imagePath = switch (t) {
                case "road" -> "/images/road.png";
                case "forest" -> "/images/forest.png";
                case "building" -> "/images/building.png";
                case "swamp" -> "/images/swamp.png";
                case "water" -> "/images/water.png";
                default -> "/images/default.png";
            };
            return new TileGraphic(imagePath);
        });
    }

    public static int getGraphicCount() {
        return graphics.size();
    }
}

