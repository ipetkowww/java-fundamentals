package lab_tasks;

import java.util.Scanner;

public class L12_RefactorSpecialNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int currentNumber;

        for (int i = 1; i <= inputNumber; i++) {
            String isSpecialNumber = "False";
            currentNumber = i;
            while (currentNumber > 0) {
                sum += currentNumber % 10;;
                currentNumber = currentNumber / 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                isSpecialNumber = "True";
            }
            System.out.printf("%d -> %s%n", i, isSpecialNumber);
            sum = 0;
        }
    }
}