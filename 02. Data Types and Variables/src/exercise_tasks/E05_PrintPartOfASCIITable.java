package exercise_tasks;

import java.util.Scanner;

public class E05_PrintPartOfASCIITable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int start = Math.min(firstNumber, secondNumber);
        int end = Math.max(firstNumber, secondNumber);

        for (int i = start; i <= end; i++) {
            System.out.printf("%c ", (char) i);
        }
    }
}