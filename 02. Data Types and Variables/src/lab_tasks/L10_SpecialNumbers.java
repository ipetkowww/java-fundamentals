package lab_tasks;

import java.util.Scanner;

public class L10_SpecialNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= inputNumber; i++) {
            String result = "False";
            int sumOfDigits = getSumOfDigits(i);
            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                result = "True";
            }
            System.out.printf("%d -> %s%n", i, result);
        }
    }

    static int getSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }
}