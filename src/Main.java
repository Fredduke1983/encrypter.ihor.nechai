import executable.ClientInterface;
import executable.Program;


public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            ClientInterface clientInterface = new ClientInterface();
            Program program = new Program();

            args = clientInterface.getArrayNewArgs();

            try {
                program.run(args);
            } catch (NullPointerException e) {
                System.out.println("Вихід з програми");
            }
        }
    }
}