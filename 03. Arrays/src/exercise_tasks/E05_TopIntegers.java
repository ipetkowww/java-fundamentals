package exercise_tasks;

import java.util.Scanner;

public class E05_TopIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getArrayOfIntegers(scanner.nextLine().split("\\s+"));


        for (int i = 0; i < numbers.length; i++) {
            boolean isBigger = true;
            int currentElement = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if (currentElement <= numbers[j]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.printf("%d ", currentElement);
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