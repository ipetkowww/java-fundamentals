package exercise_tasks;

import java.util.Scanner;

public class E02_CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int sumOfCharacters = getSumOfCharacters(input[0], input[1]);
        System.out.println(sumOfCharacters);
    }

    static int getSumOfCharacters(String text, String otherText) {
        String longerText = text.length() > otherText.length() ? text : otherText;
        int sum = 0;

        for (int i = 0; i < longerText.length(); i++) {
            if (i < text.length() && i < otherText.length()) {
                sum += text.charAt(i) * otherText.charAt(i);
            } else {
                sum += longerText.charAt(i);
            }
        }
        return sum;
    }
}
