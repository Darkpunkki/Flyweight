package Mediator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class ChatApplication extends Application {
    private ChatMediator mediator = new ChatMediatorImpl();

    @Override
    public void start(Stage primaryStage) throws Exception {
        createClientWindow("Alice");
        createClientWindow("Bob");
        createClientWindow("Charlie");
    }

    private void createClientWindow(String username) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mediator/ChatClientView.fxml"));
        Scene scene = new Scene(loader.load());

        ChatClientController controller = loader.getController();

        ChatClientImpl chatClient = new ChatClientImpl(username, mediator);
        controller.setChatClient(chatClient);

        mediator.addClient(chatClient);

        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
