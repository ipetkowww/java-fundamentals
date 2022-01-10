package exercise_tasks;

import java.util.Scanner;

public class E04_ArrayRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getArrayOfIntegers(scanner.nextLine().split("\\s+"));
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            int firstElement = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = firstElement;
        }
        printArrayElements(numbers);
    }

    static int[] getArrayOfIntegers(String[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    static void printArrayElements(int[] array) {
        for (int element : array) {
            System.out.printf("%d ", element);
        }
    }
}