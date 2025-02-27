package crypto;

import crypto.rush.executable.ClientInterface;
import crypto.rush.executable.Program;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        if (args.length == 0) {
            ClientInterface clientInterface = new ClientInterface();
            args = clientInterface.getArrayNewArgs();
        }
        try {
            program.run(args);
        } catch (Exception e) {
            System.out.println("Вихід з програми");
        }
    }
}