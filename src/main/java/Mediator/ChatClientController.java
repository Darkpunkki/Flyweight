package Mediator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

import java.util.List;

public class ChatClientController {
    @FXML
    private ListView<HBox> messageListView;

    @FXML
    private TextField messageField;

    @FXML
    private ComboBox<String> recipientComboBox;

    @FXML
    private Button sendButton;

    private ChatClientImpl chatClient;

    public void initialize() {
        // Initialization code if needed
    }

    public void setChatClient(ChatClientImpl chatClient) {
        this.chatClient = chatClient;
        chatClient.setController(this);
    }

    @FXML
    private void handleSendButtonAction(ActionEvent event) {
        String message = messageField.getText();
        String recipient = recipientComboBox.getValue();
        if (message != null && !message.isEmpty()) {
            if ("Broadcast".equals(recipient)) {
                chatClient.sendBroadcastMessage(message);
            } else if (recipient != null && !recipient.isEmpty()) {
                chatClient.sendMessage(message, recipient);
                displayMessage("Me to " + recipient, message, false);
            }
            messageField.clear();
        }
    }

    public void displayMessage(String sender, String message, boolean isBroadcast) {
        HBox messageItem = new HBox();
        messageItem.setSpacing(5);

        Text senderText = new Text(sender + ": ");
        senderText.setFont(Font.font("System", FontWeight.BOLD, 12));

        Text messageText = new Text(message);
        messageText.setFont(Font.font("System", 12));

        if (isBroadcast) {
            messageText.setFill(Color.BLUE);
        } else {
            messageText.setFill(Color.BLACK);
        }

        messageItem.getChildren().addAll(senderText, messageText);

        messageListView.getItems().add(messageItem);
    }

    public void updateRecipientList(List<String> usernames) {
        recipientComboBox.getItems().clear();
        recipientComboBox.getItems().add("Broadcast");
        recipientComboBox.getItems().addAll(usernames);
        recipientComboBox.getItems().remove(chatClient.getUsername());
    }
}
