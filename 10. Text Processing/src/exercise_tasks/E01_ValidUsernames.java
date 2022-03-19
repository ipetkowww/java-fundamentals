package exercise_tasks;

import java.util.Scanner;

public class E01_ValidUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            boolean validLength = isValidLength(username);
            boolean isContains = isContains(username);
            if (validLength && isContains) {
                System.out.println(username);
            }
        }

    }

    static boolean isValidLength(String username) {
        return username.length() >= 3 && username.length() <= 16;
    }

    static boolean isContains(String username) {
        boolean result = true;

        for (var i = 0; i < username.length(); i++) {
            char currentChar = username.charAt(i);
            if (Character.isDigit(currentChar)) {
                continue;
            } else if (Character.isLetter(currentChar)) {
                continue;
            } else if (currentChar == '-') {
                continue;
            } else if (currentChar == '_') {
                continue;
            }
            result = false;
        }
        return result;
    }

}
