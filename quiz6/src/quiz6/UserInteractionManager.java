package quiz6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInteractionManager {
    private CommunicationManager commManager;
    private List<String> chatHistory;
    private Logger logger;

    public UserInteractionManager(CommunicationManager commManager, Logger logger) {
        this.commManager = commManager;
        this.chatHistory = new ArrayList<>();
        this.logger = logger;
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("User: ");
            String userMessage = scanner.nextLine();
            chatHistory.add("User: " + userMessage);
            logger.log("User: " + userMessage);
            String response = commManager.sendMessage(userMessage, chatHistory);
            System.out.println("Chatbot: " + response);
            chatHistory.add("Chatbot: " + response);
            logger.log("Chatbot: " + response);
        }
    }
}
