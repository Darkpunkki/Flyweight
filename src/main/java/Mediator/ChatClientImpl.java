package Mediator;

import java.util.List;

public class ChatClientImpl implements ChatClient {
    private String username;
    private ChatMediator mediator;
    private ChatClientController controller;

    public ChatClientImpl(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        System.out.println("ChatClientImpl created for user: " + username);
    }

    @Override
    public void receiveMessage(String message, String senderUsername, boolean isBroadcast) {
        controller.displayMessage(senderUsername, message, isBroadcast);
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void sendMessage(String message, String receiverUsername) {
        mediator.sendMessage(message, username, receiverUsername);
    }

    public void sendBroadcastMessage(String message) {
        mediator.broadcastMessage(message, username);
    }

    public void setController(ChatClientController controller) {
        this.controller = controller;
    }

    @Override
    public void updateClientList(List<String> usernames) {
        controller.updateRecipientList(usernames);
    }
}
