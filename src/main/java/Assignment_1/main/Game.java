package Assignment_1.main;

import Assignment_1.factory.CityMap;
import Assignment_1.factory.MegaMap;
import Assignment_1.factory.WildernessMap;
import Assignment_1.map.Map;
import Assignment_1.tiles.TileGraphicFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Game extends Application {
    private static Map map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a map type: 1 for CityMap, 2 for WildernessMap, 3 for MegaMap");
        int choice = scanner.nextInt();

        map = switch (choice) {
            case 1 -> new CityMap(10, 10);
            case 2 -> new WildernessMap(10, 10);
            case 3 -> new MegaMap(12,12);
            default -> {
                System.out.println("Invalid choice, defaulting to CityMap.");
                yield new CityMap(10, 10);
            }
        };

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int tileSize = 50;
        Canvas canvas = new Canvas(map.tiles[0].length * tileSize, map.tiles.length * tileSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        map.render(gc, tileSize);

        System.out.println("Total unique TileGraphics created: " + TileGraphicFactory.getGraphicCount());

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        primaryStage.setTitle("RPG Map Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
