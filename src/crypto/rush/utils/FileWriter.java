package crypto.rush.utils;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {

    public static void writeToFile(String command, String filepath, StringBuilder resultLine, int key) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(UpdateFileName.createCommandFileName(filepath, command)))) {
            writer.write(resultLine.toString());
            Messages.printMsg(key);
        }
    }
}
