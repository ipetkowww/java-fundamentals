import java.util.Scanner;

public class TheImitationGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] arguments = input.split("\\|");
            switch (arguments[0]) {
                case "Move":
                    move(message, Integer.parseInt(arguments[1]));
                    break;
                case "Insert":
                    insert(message, Integer.parseInt(arguments[1]), arguments[2]);
                    break;
                case "ChangeAll":
                    changeAll(message, arguments[1], arguments[2]);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }

    static void changeAll(StringBuilder encryptedMessage, String substring, String replacement) {
        int index = encryptedMessage.indexOf(substring);
        while (index != -1) {
            encryptedMessage.replace(index, index  + substring.length(), replacement);
            index = encryptedMessage.indexOf(substring);
        }
    }

    static void insert(StringBuilder encryptedMessage, int index, String value) {
        encryptedMessage.insert(index , value);
    }

    static void move(StringBuilder encryptedMessage, int numberOfLetters) {
        String substring = encryptedMessage.substring(0, numberOfLetters);
        encryptedMessage.replace(0, numberOfLetters, "");
        encryptedMessage.append(substring);
    }
}
