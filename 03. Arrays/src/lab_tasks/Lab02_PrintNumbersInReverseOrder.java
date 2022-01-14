package lab_tasks;

import java.util.Scanner;

public class Lab02_PrintNumbersInReverseOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = scanner.nextInt();
        int[] array = new int[numbersCount];

        for (int i = 0; i < numbersCount; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.printf("%d ", array[i]);
        }
    }
}