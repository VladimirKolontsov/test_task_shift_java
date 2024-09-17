package org.example.write;

import org.example.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToStrFile {

    public static void writeToStringFile(String data) {

        // указываем путь к файлу
        String filePath = Main.filePathToWriteString;

        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            FileWriter writer = new FileWriter(file, true);
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
