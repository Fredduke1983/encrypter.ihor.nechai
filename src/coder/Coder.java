package coder;

import Constants.Alphabets;
import service.IndexOfChar;

public class Coder {
    private final IndexOfChar indexOfChar = new IndexOfChar();

    public char[] encrypt(char[] s, int key) {
        return process(s, key, true);
    }

    public char[] decrypt(char[] s, int key) {
        return process(s, key, false);
    }

    private char[] process(char[] s, int key, boolean isEncrypt) {
        char[] result = new char[s.length];

        for (int i = 0; i < s.length; i++) {
            if (Character.isUpperCase(s[i])) {
                result[i] = shiftChar(s[i], key, Alphabets.UPPERCASE_ALPHABET_EN, isEncrypt);
            } else {
                result[i] = shiftChar(s[i], key, Alphabets.LOWERCASE_ALPHABET_EN, isEncrypt);
            }
        }
        return result;
    }

    private char shiftChar(char c, int key, char[] alphabet, boolean isEncrypt) {
        int index = indexOfChar.getIndexOfChar(alphabet, c);
        int length = alphabet.length;

        int newIndex = isEncrypt ? (index + key) % length : (index - key + length) % length;

        return alphabet[newIndex];
    }
}
