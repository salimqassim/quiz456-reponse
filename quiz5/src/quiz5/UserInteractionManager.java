package quiz5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInteractionManager {
    private CommunicationManager commManager;
    private List<String> chatHistory;

    public UserInteractionManager(CommunicationManager commManager) {
        this.commManager = commManager;
        this.chatHistory = new ArrayList<>();
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("User: ");
            String userMessage = scanner.nextLine();
            chatHistory.add("User: " + userMessage);
            String response = commManager.sendMessage(userMessage, chatHistory);
            System.out.println("Chatbot: " + response);
            chatHistory.add("Chatbot: " + response);
        }
    }
}



