package exercise_tasks;

import java.util.Scanner;

public class E04_PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        CheckWhetherPasswordIsValid(password);
    }

    static void CheckWhetherPasswordIsValid(String password) {
        boolean validPassword = true;
        if (!isValidLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            validPassword = false;
        }
        if (!isConsistOnlyLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
            validPassword = false;
        }
        if (!isHasAtLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
            validPassword = false;
        }
        if (validPassword) {
            System.out.println("Password is valid");
        }
    }

    static boolean isValidLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    static boolean isConsistOnlyLettersAndDigits(String password) {
        boolean isValid = true;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (!(Character.isDigit(currentSymbol) || Character.isLetter(currentSymbol))) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    static boolean isHasAtLeastTwoDigits(String password) {
        int digitCount = 0;
        boolean isValid = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digitCount++;
                if (digitCount == 2) {
                    isValid = true;
                    break;
                }
            }
        }
        return isValid;
    }
}