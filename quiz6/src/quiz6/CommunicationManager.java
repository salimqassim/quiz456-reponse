package quiz6;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CommunicationManager {
    private static final String SERVICE_URL = "http://example.com/chatbot";

    public String sendMessage(String userMessage, List<String> chatHistory) {
        try {
            URL url = new URL(SERVICE_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = createJson(userMessage, chatHistory);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Response handling code here
            // ...

            return ""; // Replace with actual response
        } catch (Exception e) {
            e.printStackTrace();
            return "Error communicating with chatbot service.";
        }
    }

    private String createJson(String userMessage, List<String> chatHistory) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"userMessage\":").append("\"").append(userMessage).append("\"").append(",");
        json.append("\"chatHistory\":").append("[");
        for (int i = 0; i < chatHistory.size(); i++) {
            json.append("\"").append(chatHistory.get(i)).append("\"");
            if (i < chatHistory.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        json.append("}");
        return json.toString();
    }
}
