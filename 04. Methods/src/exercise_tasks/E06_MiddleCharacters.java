package exercise_tasks;

import java.util.Scanner;

public class E06_MiddleCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String middleChars = getMiddleChars(input);
        System.out.println(middleChars);
    }

    static String getMiddleChars(String str) {
        String middleChars = "";
        int length = str.length();

        if (str.length() % 2 == 0) {
            middleChars = "" + str.charAt((length / 2) - 1) + str.charAt((length / 2));
        } else {
            middleChars = "" + str.charAt(length / 2);
        }
        return middleChars;
    }
}