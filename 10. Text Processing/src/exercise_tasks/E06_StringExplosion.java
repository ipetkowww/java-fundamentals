package exercise_tasks;

import java.util.Scanner;

public class E06_StringExplosion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());

        int strength = 0;
        for (int i = 0; i < input.length(); i++) {
            if (strength > 0 && input.charAt(i) != '>') {
                input.deleteCharAt(i);
                strength--;
                i--;
            } else if (input.charAt(i) == '>') {
                strength += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            }
        }
        System.out.println(input);
    }
}
