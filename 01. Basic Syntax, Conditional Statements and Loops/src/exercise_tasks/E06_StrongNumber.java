package exercise_tasks;

import java.util.Scanner;

public class E06_StrongNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        int number = inputNumber;
        int sum = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            int factorial = 1;

            for (int i = 1; i <= lastDigit; i++) {
                factorial *= i;
            }
            sum += factorial;
            number /= 10;
        }
        String isStrongNumber = sum == inputNumber ? "yes" : "no";
        System.out.println(isStrongNumber);
    }
}