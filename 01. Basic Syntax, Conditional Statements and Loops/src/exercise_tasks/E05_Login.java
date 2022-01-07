package exercise_tasks;

import java.util.Scanner;

public class E05_Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String inputPassword = scanner.nextLine();

        String validPassword = new StringBuilder(username).reverse().toString();
        int invalidPasswordCount = 0;

        while (!inputPassword.equals(validPassword)) {
            invalidPasswordCount++;
            if (invalidPasswordCount >= 4) {
                System.out.printf("User %s blocked!%n", username);
                return;
            }
            System.out.println("Incorrect password. Try again.");

            inputPassword = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", username);
    }
}