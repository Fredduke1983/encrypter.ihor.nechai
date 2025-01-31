package crypto.rush.service;

import crypto.rush.commands.Command;

import java.util.ArrayList;

class DoCryptLine {
    char[] createCryptedLine(Coder coder,
                             int randomKey,
                             int key,
                             String line,
                             ArrayList<char[]> alphabets,
                             String command,
                             KeyChecker keyChecker) {
        char[] cryptedLine = null;

        try {
            Command newCommand = Command.valueOf(command);
            switch (newCommand) {
                case Command.ENCRYPT:
                    cryptedLine = coder.encrypt(line.toCharArray(), key, alphabets);
                    break;
                case Command.DECRYPT:
                    cryptedLine = coder.decrypt(line.toCharArray(), key, alphabets);
                    break;
                case Command.BRUTE_FORCE:
                    cryptedLine = coder.decrypt(line.toCharArray(), randomKey, alphabets);
                    keyChecker.findMatchesSpecialSymbols(cryptedLine);
                    break;
                default:
                    throw new IllegalArgumentException("Не підтримувана команда: " + command);
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return cryptedLine;
    }
}
