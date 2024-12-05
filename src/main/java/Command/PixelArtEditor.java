package Command;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    private static final int CELL_SIZE = 30;

    @Override
    public void start(Stage primaryStage) {
        PixelGrid pixelGrid = new PixelGrid();

        // Commands
        Command moveUp = new MoveCursorUpCommand(pixelGrid);
        Command moveDown = new MoveCursorDownCommand(pixelGrid);
        Command moveLeft = new MoveCursorLeftCommand(pixelGrid);
        Command moveRight = new MoveCursorRightCommand(pixelGrid);
        Command togglePixel = new TogglePixelCommand(pixelGrid);
        Command generateCode = new GenerateCodeCommand(pixelGrid);

        // GridPane for pixel grid
        GridPane gridPane = new GridPane();
        Rectangle[][] cells = new Rectangle[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.BLACK);
                cells[y][x] = rect;
                gridPane.add(rect, x, y);
            }
        }

        // Update the grid view
        Runnable updateGrid = () -> {
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    if (pixelGrid.getGrid()[y][x] == 1) {
                        cells[y][x].setFill(Color.BLACK);
                    } else {
                        cells[y][x].setFill(Color.WHITE);
                    }
                }
            }
            cells[pixelGrid.getCursorY()][pixelGrid.getCursorX()].setFill(Color.RED);
        };

        // Add instruction label
        Label instructionLabel = new Label(
                "Controls:\n" +
                        "Arrow Keys: Move Cursor\n" +
                        "Space: Toggle Pixel\n" +
                        "Click 'Create Code' to print the grid as a 2D array"
        );
        instructionLabel.setStyle("-fx-font-size: 14; -fx-alignment: center;");

        // "Create Code" Button
        Button createCodeButton = new Button("Create Code");
        createCodeButton.setOnAction(e -> {
            generateCode.execute();
            createCodeButton.getScene().getRoot().requestFocus();
        });

        // Layout with spacing
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(instructionLabel, gridPane, createCodeButton);

        // Scene and focus setup
        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);

        // Ensure Scene captures key events
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> moveUp.execute();
                case DOWN -> moveDown.execute();
                case LEFT -> moveLeft.execute();
                case RIGHT -> moveRight.execute();
                case SPACE -> togglePixel.execute();
            }
            updateGrid.run();
        });

        primaryStage.setOnShown(event -> scene.getRoot().requestFocus());

        primaryStage.show();
        updateGrid.run();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
