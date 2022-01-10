package exercise_tasks;

import java.util.Scanner;

public class E03_ZigZagArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[linesCount];
        int[] secondArray = new int[linesCount];

        for (int i = 0; i < linesCount; i++) {
            String[] numbers = scanner.nextLine().split("\\s+");
            int[] arrayOfIntegers = getArrayOfIntegers(numbers);

            if (i % 2 == 0) {
                firstArray[i] = arrayOfIntegers[0];
                secondArray[i] = arrayOfIntegers[1];
            } else {
                firstArray[i] = arrayOfIntegers[1];
                secondArray[i] = arrayOfIntegers[0];
            }
        }
        printElementsOfArray(firstArray);
        printElementsOfArray(secondArray);
    }

    static int[] getArrayOfIntegers(String[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    static void printElementsOfArray(int[] array) {
        for (int element : array) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }
}