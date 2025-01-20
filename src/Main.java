import service.FileHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String command = "";
        String filepath = "";
        int key = 0;

        if (args.length > 0) {
            try {
                command = args[0];
                filepath = args[1];
                key = Integer.parseInt(args[2]);

                FileHandler fileHandler = new FileHandler(command, filepath, key);
                fileHandler.fileIO();
            } catch (RuntimeException e) {
                System.out.println("Please, fill all fields correct. It must be " +
                        "(\"[ENCRYPT]/[DECRYPT]/[BRUTE_FORCE] c:/test/... [1-30]\")");
            }
        } else {
            System.out.println("Next time try to fill all fields correct ;)" +
                    " like: \"java -jar Encrypter.jar DECRYPT c:/test/file[ENCRYPTED].txt 2\"");
        }
    }
}