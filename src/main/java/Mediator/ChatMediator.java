package Mediator;

import java.util.List;

public interface ChatMediator {
    void sendMessage(String message, String senderUsername, String receiverUsername);
    void addClient(ChatClient client);
    void broadcastMessage(String message, String senderUsername);
    List<String> getClientUsernames();

}
