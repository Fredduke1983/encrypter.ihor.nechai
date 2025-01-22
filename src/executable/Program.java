package executable;

import service.FileHandler;

public class Program {

    public void run(String[] args) {

        try {
            String command = args[0];
            String filepath = args[1];
            int key = args.length > 2 ? Math.abs(Integer.parseInt(args[2])) : 0;

            FileHandler fileHandler = new FileHandler(command, filepath, key);
            fileHandler.fileIO();
        } catch (RuntimeException e) {
            System.out.println("Please, fill all fields correct. It must be " +
                    "(\"[ENCRYPT]/[DECRYPT]/[BRUTE_FORCE] c:/folder/*.txt [1-9999...]\")");
        }
    }
}
