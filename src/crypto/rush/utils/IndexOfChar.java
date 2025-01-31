package crypto.rush.utils;

public class IndexOfChar {

    public int getIndexOfChar(char[] chars, char letter) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == letter) {
                return i;
            }
        }
        return -1;
    }

}
