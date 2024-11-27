package Mediator;

import java.util.*;

public class ChatMediatorImpl implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void sendMessage(String message, String senderUsername, String receiverUsername) {
        ChatClient receiver = clients.get(receiverUsername);
        if (receiver != null) {
            receiver.receiveMessage(message, senderUsername, false); // Direct message
        }
    }

    @Override
    public void broadcastMessage(String message, String senderUsername) {
        for (ChatClient client : clients.values()) {
                client.receiveMessage(message, senderUsername, true);
        }
    }

    @Override
    public void addClient(ChatClient client) {
        clients.put(client.getUsername(), client);
        updateClientLists();
    }

    @Override
    public List<String> getClientUsernames() {
        return new ArrayList<>(clients.keySet());
    }

    private void updateClientLists() {
        List<String> usernames = getClientUsernames();
        for (ChatClient client : clients.values()) {
            client.updateClientList(usernames);
        }
    }
}
