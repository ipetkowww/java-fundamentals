package lab_tasks;

import java.util.Scanner;

public class Lab04_ReverseArrayOfStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\s+");

        for (int i = 0; i < array.length / 2; i++) {
            String firstElement = array[i];
            String lastElement = array[array.length - i - 1];

            array[i] = lastElement;
            array[array.length - i - 1] = firstElement;
        }

        for (String element : array) {
            System.out.printf("%s ", element);
        }
    }
}