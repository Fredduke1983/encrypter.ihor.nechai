package service;

import java.util.ArrayList;

public class KeyChecker {

    private static final ArrayList<Boolean> dotsSpacesMatches = new ArrayList<>();
    private static final ArrayList<Boolean> spacesMatches = new ArrayList<>();

    public void setListsClear() {
        dotsSpacesMatches.clear();
        spacesMatches.clear();
    }

    public void findMatches(char[] cryptedLine) {
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

    public boolean getIsCorrectKey() {
        return isCorrectKey();
    }

    private boolean isCorrectKey() {
        boolean hasTrueInMatches1 = KeyChecker.dotsSpacesMatches.contains(true);
        boolean isAllTrueInMatches2 = !KeyChecker.spacesMatches.contains(false);
        return hasTrueInMatches1 && isAllTrueInMatches2;
    }
}
