package lab_tasks;

import java.util.Scanner;

public class Lab07_RepeatString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repeat = scanner.nextInt();
        String repeatString = getRepeatString(input, repeat);
        System.out.println(repeatString);
    }

    static String getRepeatString(String str, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(str);
        }
        return result.toString();
    }
}