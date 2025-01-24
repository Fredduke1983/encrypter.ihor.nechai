package service;

import Constants.Alphabets;

import java.util.ArrayList;
import java.util.HashMap;

class AllocateLang {

    private static final char[] upAlphabetEn = Alphabets.UPPERCASE_ALPHABET_EN;
    private static final char[] lowAlphabetEn = Alphabets.LOWERCASE_ALPHABET_EN;
    private static final char[] upAlphabetUa = Alphabets.UPPERCASE_ALPHABET_UA;
    private static final char[] lowAlphabetUa = Alphabets.LOWERCASE_ALPHABET_UA;

    static ArrayList<char[]> whatLang(char[] c) {

        int countEn = 0;
        int countUa = 0;
        String lang;

        ArrayList<char[]> enAlphabets = new ArrayList<>();
        enAlphabets.add(upAlphabetEn);
        enAlphabets.add(lowAlphabetEn);

        ArrayList<char[]> uaAlphabets = new ArrayList<>();
        uaAlphabets.add(upAlphabetUa);
        uaAlphabets.add(lowAlphabetUa);

        HashMap<String, ArrayList<char[]>> mapOfLang = new HashMap<>();
        mapOfLang.put("EN", enAlphabets);
        mapOfLang.put("UA", uaAlphabets);

        for (int i = 0; i < 5; i++) {
            if (contains(upAlphabetEn, c[i]) || contains(lowAlphabetEn, c[i])) {
                countEn++;
            } else if ((contains(upAlphabetUa, c[i]) || contains(lowAlphabetUa, c[i]))) {
                countUa++;
            }
        }
        lang = countEn > countUa ? "EN" : "UA";
        return mapOfLang.get(lang);
    }

    private static boolean contains(char[] array, char target) {
        for (char c : array) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }
}
