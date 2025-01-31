package crypto.rush.executable;

import crypto.rush.service.FileHandler;

public class Program {

    public void run(String[] args) {

        String command = args[0];
        String filepath = args[1];
        try {
            int key = args.length > 2 ? Math.abs(Integer.parseInt(args[2])) : 0;
            FileHandler fileHandler = new FileHandler();
            fileHandler.fileProcessing(command, filepath, key);
        } catch (NumberFormatException e) {
            System.out.println("В поле \"key\" прохання введіть ціле число");
        }

    }
}
