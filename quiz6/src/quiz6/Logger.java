package quiz6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private BufferedWriter writer;

    public Logger(String filename) {
        try {
            writer = new BufferedWriter(new FileWriter(filename, true)); // Append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
