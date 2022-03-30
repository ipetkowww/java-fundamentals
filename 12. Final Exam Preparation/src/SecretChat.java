import java.util.Scanner;

public class SecretChat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] arguments = input.split(":\\|:");
            String command = arguments[0];
            boolean isError = false;

            switch (command) {
                case "InsertSpace":
                    insertSpace(message, Integer.parseInt(arguments[1]));
                    break;
                case "Reverse":
                    if (message.indexOf(arguments[1]) != -1) {
                        reverse(message, arguments[1]);
                    } else {
                        isError = true;
                    }
                    break;
                case "ChangeAll":
                    changeAll(message, arguments[1], arguments[2]);
                    break;
            }
            if (isError) {
                System.out.println("error");
            } else {
                System.out.println(message);
            }
            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }

    private static void changeAll(StringBuilder message, String subStr, String replacement) {
        String replaced = message.toString().replace(subStr, replacement);
        message.setLength(0);
        message.append(replaced);
    }

    private static void reverse(StringBuilder message, String subStr) {
        int index = message.indexOf(subStr);
        message.delete(index, index + subStr.length());
        StringBuilder reversed = new StringBuilder(subStr);
        reversed.reverse();
        message.append(reversed);
    }

    private static void insertSpace(StringBuilder message, int index) {
        message.insert(index, " ");
    }
}
