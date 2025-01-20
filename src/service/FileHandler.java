package service;

import Constants.Alphabets;
import coder.Coder;

import java.io.*;

public class FileHandler {

    private final String filepath;
    private final String command;
    private final int key;
    private boolean isCorrectKeyCheck = false;
    private final KeyChecker keyChecker = new KeyChecker();

    public FileHandler(String command, String filepath, int key) {
        this.command = command;
        this.filepath = filepath;
        this.key = key;
    }

    public void fileIO() {
        try {
            Coder coder = new Coder();
            int randomKey = 1;

            while (!isCorrectKeyCheck && randomKey < Alphabets.LOWERCASE_ALPHABET_EN.length) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                    String line;
                    keyChecker.setListsClear();

                    StringBuilder resultToWrite = new StringBuilder();

                    while ((line = reader.readLine()) != null) {
                        char[] cryptedLine;

                        switch (command) {
                            case "ENCRYPT":
                                cryptedLine = coder.encrypt(line.toCharArray(), key);
                                break;
                            case "DECRYPT":
                                cryptedLine = coder.decrypt(line.toCharArray(), key);
                                break;
                            case "BRUTE_FORCE":
                                cryptedLine = coder.decrypt(line.toCharArray(), randomKey);
                                keyChecker.findMatches(cryptedLine);
                                break;
                            default:
                                throw new IllegalArgumentException("Unsupported command: " + command);
                        }
                        resultToWrite.append(cryptedLine).append(System.lineSeparator());
                    }

                    isCorrectKeyCheck = command == "BRUTE_FORCE" ? keyChecker.getIsCorrectKey() : true;

                    if (isCorrectKeyCheck) {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(UpdateFileName.updateFileName(filepath, command)))) {
                            writer.write(resultToWrite.toString());
                        }
                    } else {
                        randomKey++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("I/O Error: file not found");
        } catch (IOException e) {
            System.out.println("I/O Error: maybe some fields are empty");
        }
    }
}
