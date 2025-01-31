package crypto.rush.service;

import java.util.ArrayList;
import java.util.List;

class KeyChecker {

    private static final List<Boolean> dotsSpacesMatches = new ArrayList<>();
    private static final List<Boolean> spacesMatches = new ArrayList<>();

    void setListsClear() {
        dotsSpacesMatches.clear();
        spacesMatches.clear();
    }

    void findMatchesSpecialSymbols(char[] cryptedLine) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cryptedLine);

        int length = stringBuilder.toString().split(" ").length;
        dotsSpacesMatches.add(stringBuilder.toString().matches(".*(\\s[A-Z][a-z]|\\,\\s).*"));

        if (length > 1) {
            spacesMatches.add(true);
        } else {
            spacesMatches.add(false);
        }
    }

    boolean getIsCorrectKey() {
        boolean hasTrueInMatches1 = KeyChecker.dotsSpacesMatches.contains(true);
        boolean isAllTrueInMatches2 = !KeyChecker.spacesMatches.contains(false);
        return hasTrueInMatches1 && isAllTrueInMatches2;
    }
}
