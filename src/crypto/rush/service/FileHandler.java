package crypto.rush.service;

import crypto.rush.commands.Command;
import crypto.rush.constant.Alphabets;
import crypto.rush.utils.FileWriter;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileHandler {

    private boolean isKeyValid = false;
    private final KeyChecker keyChecker = new KeyChecker();
    private final DoCryptLine doCryptLine = new DoCryptLine();
    private final Coder coder = new Coder();

    public void fileProcessing(String command, String filepath, int key) {
        try {
            Path path = Path.of(filepath).getRoot();
            if (path == null) {
                throw new NullPointerException("I/O Error: " + filepath + ": Не коректна адреса");
            }
            int randomKey = 0;

            while (isKeyForBruteNotCorrect(randomKey)) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                    keyChecker.setListsClear();

                    StringBuilder resultLine = checkingProcessForWriteToFile(
                            reader,
                            coder,
                            randomKey,
                            key,
                            command);

                    isKeyValid = isKeyValid(command);
                    if (isKeyValid) {
                        FileWriter.writeToFile(command, filepath, resultLine, command.equals("BRUTE_FORCE") ? randomKey : key);
                    } else {
                        randomKey++;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("I/O Error: файл не знайдено");
        } catch (IOException e) {
            System.out.println("I/O Error: схоже не всі поля заповнені, або заповнені не коректно");
        }
    }

    private boolean isKeyValid(String command) {
        return !command.equals(Command.BRUTE_FORCE.name()) || keyChecker.getIsCorrectKey();
    }

    private StringBuilder checkingProcessForWriteToFile(BufferedReader reader,
                                                        Coder coder,
                                                        int randomKey,
                                                        int key,
                                                        String command) throws IOException {
        String oneLineRead;
        StringBuilder resultLine = new StringBuilder();

        while ((oneLineRead = reader.readLine()) != null) {
            try {
                ArrayList<char[]> alphabets = AllocateLang.whatLang(oneLineRead.toCharArray());
                char[] cryptedLine = doCryptLine.createCryptedLine(coder, randomKey, key, oneLineRead, alphabets, command, keyChecker);
                resultLine.append(cryptedLine).append(System.lineSeparator());
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        return resultLine;
    }

    private boolean isKeyForBruteNotCorrect(int randomKey) {
        return !isKeyValid && randomKey < Alphabets.LOWERCASE_ALPHABET_EN.length;
    }
}
