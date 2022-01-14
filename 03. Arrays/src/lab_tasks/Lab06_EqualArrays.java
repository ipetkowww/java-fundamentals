package lab_tasks;

import java.util.Scanner;

public class Lab06_EqualArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = getNumbersArray(scanner.nextLine().split("\\s+"));
        int[] secondArray = getNumbersArray(scanner.nextLine().split("\\s+"));
        boolean areIdentical = true;
        int sum = 0;
        int index = 0;


        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                areIdentical = false;
                index = i;
                break;
            } else {
                sum += firstArray[i];
            }
        }
        if (areIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }
    }

    static int[] getNumbersArray(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}