import java.util.Scanner;

public class PasswordReset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] arguments = input.split("\\s+");
            String command = arguments[0];

            switch (command) {
                case "TakeOdd":
                    password = takeOdd(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(arguments[1]);
                    int length = Integer.parseInt(arguments[2]);
                    cut(password, index, length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String subStr = arguments[1];
                    String substitute = arguments[2];
                    boolean isSubstituted = substitute(password, subStr, substitute);
                    if (isSubstituted) {
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }

    private static boolean substitute(StringBuilder password, String subStr, String substitute) {
        boolean result = false;
        int index = password.indexOf(subStr);
        while (index != -1) {
            result = true;
            password.replace(index, index + subStr.length(), substitute);
            index = password.indexOf(subStr);
        }
        return result;
    }

    private static void cut(StringBuilder password, int index, int length) {
        password.delete(index, index + length);
    }

    private static StringBuilder takeOdd(StringBuilder password) {
        StringBuilder newPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                newPassword.append(password.charAt(i));
            }
        }
        return newPassword;
    }
}
