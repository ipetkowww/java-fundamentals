package exercise_tasks;

import java.util.Scanner;

public class E04_SumOfChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < lines; i++) {
            char inputChar = scanner.nextLine().charAt(0);
            sum += inputChar;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}