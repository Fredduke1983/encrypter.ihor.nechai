package service;

import java.util.ArrayList;

public class KeyChecker {

    private static int key = 0;
    private static ArrayList<Boolean> dotsSpacesMatches = new ArrayList<>();
    private static ArrayList<Boolean> spacesMatches = new ArrayList<>();

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
//        System.out.println(dotsSpacesMatches);
        return isCorrectKey(dotsSpacesMatches, spacesMatches);
    }

    private boolean isCorrectKey(ArrayList<Boolean> matches1, ArrayList<Boolean> matches2) {

        boolean hasTrueInMatches1 = matches1.contains(true);
        boolean isAllTrueInMatches2 = !matches2.contains(false);

        return hasTrueInMatches1 && isAllTrueInMatches2;
    }
}
