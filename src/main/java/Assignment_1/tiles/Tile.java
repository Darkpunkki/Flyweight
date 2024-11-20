package Assignment_1.tiles;

import javafx.scene.canvas.GraphicsContext;

public interface Tile {
    char getCharacter();
    String getType();
    void action();
    void render(GraphicsContext gc, int x, int y,  int tileSize);
}
