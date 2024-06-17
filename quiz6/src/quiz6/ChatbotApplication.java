import quiz6.UserInteractionManager;
import quiz6.DummyCommunicationManager;
import quiz6.Logger;

public class ChatbotApplication {
    public static void main(String[] args) {
        DummyCommunicationManager dummyCommManager = new DummyCommunicationManager();
        Logger logger = new Logger("chat_log.txt");
        UserInteractionManager uiManager = new UserInteractionManager(dummyCommManager, logger);
        uiManager.startChat();
        logger.close();
    }
}
