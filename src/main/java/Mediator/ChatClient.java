package Mediator;

import java.util.List;

public interface ChatClient {
    void receiveMessage(String message, String senderUsername, boolean isBroadcast);
    String getUsername();
    void updateClientList(List<String> usernames);
}
