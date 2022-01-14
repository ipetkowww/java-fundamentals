package lab_tasks;

import java.util.Scanner;

public class Lab07_CondenseArrayToNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getNumbersArray(scanner.nextLine().split("\\s+"));

        while (numbers.length > 1) {
            int[] result = new int[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {
                result[i] = numbers[i] + numbers[i + 1];
            }
            numbers = result;
        }
        System.out.println(numbers[0]);
    }

    static int[] getNumbersArray(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}