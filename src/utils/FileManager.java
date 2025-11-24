package utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveReport(String filename, String content) {
        try {
            FileWriter fw = new FileWriter("storage/" + filename);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            System.err.println("Unable to save file: " + e.getMessage());
        }
    }
}
