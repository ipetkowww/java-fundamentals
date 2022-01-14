package lab_tasks;

import java.util.Scanner;

public class Lab05_EvenAndOddSubtraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getNumbersArray(scanner.nextLine().split("\\s+"));
        int evenSum = 0;
        int oddSum = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }
        System.out.println(evenSum - oddSum);
    }

    static int[] getNumbersArray(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}