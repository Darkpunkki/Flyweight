package Assignment_1.tiles;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

// intrinsic state
public class TileGraphic {
    // private final Color color;
    private final Image image;

    public TileGraphic(String path) {
        // System.out.println("Loading image from: " + path);
        this.image = new Image(getClass().getResourceAsStream(path));
    }

    /*
    public Color getColor() {
        return color;
    }
    */

    public Image getImage() {
        return image;
    }
}
