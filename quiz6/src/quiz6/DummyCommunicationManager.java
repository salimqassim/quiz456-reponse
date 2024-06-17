package quiz6;

import java.util.List;

public class DummyCommunicationManager extends CommunicationManager {
    @Override
    public String sendMessage(String userMessage, List<String> chatHistory) {
        return "This is a dummy response to: " + userMessage;
    }
}
