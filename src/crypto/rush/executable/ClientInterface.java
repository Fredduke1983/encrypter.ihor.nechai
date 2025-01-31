package crypto.rush.executable;

import crypto.rush.commands.Command;

import java.util.Scanner;

public class ClientInterface {

    public String[] getArrayNewArgs() {
        Scanner scanner = new Scanner(System.in);
        String[] newArgs = new String[3];

        System.out.print("Введіть один із доступних символів:" +
                "\n [e] - шифрування," +
                "\n [d] - дешифрування," +
                "\n [b] - дешифрування способом BRUTE_FORCE: ");
        switch (scanner.nextLine()) {
            case "e": {
                newArgs[0] = Command.ENCRYPT.name();
                break;
            }
            case "d": {
                newArgs[0] = Command.DECRYPT.name();
                break;
            }
            case "b": {
                newArgs[0] = Command.BRUTE_FORCE.name();
                break;
            }
            default: {
                System.out.println("Не вірне значення");
                return null;
            }
        }
        System.out.print("Введіть коректний шлях до файлу: ");
        newArgs[1] = scanner.nextLine();

        if (newArgs[0] != Command.BRUTE_FORCE.name()) {
            System.out.print("Введіть ціле число як ключ для шифрування/дешифрування" +
                    " вашого файлу: ");
            newArgs[2] = scanner.nextLine();
        } else newArgs[2] = "0";
        return newArgs;
    }
}
