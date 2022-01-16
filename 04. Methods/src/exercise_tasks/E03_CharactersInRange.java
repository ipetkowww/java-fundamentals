package exercise_tasks;

import java.util.Scanner;

public class E03_CharactersInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        printCharsInRange(firstChar, secondChar);
    }

    static void printCharsInRange(char start, char end) {
        int startRange = Math.min(start, end);
        int endRange = Math.max(start, end);

        for (int i = startRange + 1; i < endRange; i++) {
            System.out.printf("%c ", (char)i);
        }
    }
}