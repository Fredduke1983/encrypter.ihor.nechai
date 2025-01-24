package coder;

import service.IndexOfChar;

import java.util.ArrayList;

public class Coder {

    private final IndexOfChar indexOfChar = new IndexOfChar();

    public char[] encrypt(char[] s, int key, ArrayList<char[]> lang) {
        return process(s, key, true, lang);
    }

    public char[] decrypt(char[] chars, int key, ArrayList<char[]> lang) {
        return process(chars, key, false, lang);
    }

    private char[] process(char[] chars, int key, boolean isEncrypt, ArrayList<char[]> lang) {
        char[] result = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                result[i] = shiftChar(chars[i], key, lang.getFirst(), isEncrypt);
            } else {
                result[i] = shiftChar(chars[i], key, lang.get(1), isEncrypt);
            }
        }
        return result;
    }

    private char shiftChar(char symbol, int key, char[] alphabet, boolean isEncrypt) {
        int lengthOfAlphabet = alphabet.length;
        int countOfRound = (int) Math.ceil((double) key / lengthOfAlphabet);
        int index = indexOfChar.getIndexOfChar(alphabet, symbol);

        if (index == -1) {
            return symbol;
        }
        int newIndex = isEncrypt ? (index + key) % lengthOfAlphabet : (index - key + lengthOfAlphabet * countOfRound) % lengthOfAlphabet;

        return alphabet[newIndex];
    }
}
