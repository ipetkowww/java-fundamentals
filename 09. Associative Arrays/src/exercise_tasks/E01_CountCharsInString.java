package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01_CountCharsInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> charOccurrences = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (!Character.isWhitespace(currentChar)) {
                Integer occurrence = charOccurrences.get(currentChar);
                if (occurrence == null) {
                    occurrence = 0;
                }
                charOccurrences.put(currentChar, occurrence + 1);
            }
        }

        charOccurrences.forEach((key, value) -> System.out.printf("%c -> %d%n", key, value));
    }
}