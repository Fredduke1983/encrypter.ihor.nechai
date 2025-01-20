package service;

public class UpdateFileName {

    public static String updateFileName(String filePath, String command) {
        int indexOfDot = filePath.indexOf(".");
        String fileName = filePath.substring(0, indexOfDot);
        String fileExtention = filePath.substring(indexOfDot);
        String add = "[" + command + "ED]";

        return fileName + add + fileExtention;
    }
}
