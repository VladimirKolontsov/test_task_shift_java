package org.example.write;

import org.example.Main;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToStrFile {

    public static void writeToStringFile(String data) {

        // указываем путь к файлу
        String filePath = Main.filePathToWriteString;

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
