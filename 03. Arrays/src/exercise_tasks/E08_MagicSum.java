package exercise_tasks;

import java.util.Scanner;

public class E08_MagicSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getArrayOfIntegers(scanner.nextLine().split("\\s+"));
        int inputSum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int currentNumber = numbers[j];
                int sum = number + currentNumber;
                if (sum == inputSum) {
                    System.out.printf("%d %d%n", number, currentNumber);
                }
            }
        }
    }

    static int[] getArrayOfIntegers(String[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }
}