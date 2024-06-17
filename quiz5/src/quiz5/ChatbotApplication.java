import quiz5.UserInteractionManager;
import quiz5.DummyCommunicationManager;

public class ChatbotApplication {
    public static void main(String[] args) {
        DummyCommunicationManager dummyCommManager = new DummyCommunicationManager();
        UserInteractionManager uiManager = new UserInteractionManager(dummyCommManager);
        uiManager.startChat();
    }
}

