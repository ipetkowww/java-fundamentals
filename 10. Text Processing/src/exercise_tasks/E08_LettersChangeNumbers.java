package exercise_tasks;

import java.util.Scanner;

public class E08_LettersChangeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String element : input) {
            char letterBeforeNumber = element.charAt(0);
            double number = Double.parseDouble(element.substring(1, element.length() - 1));
            char letterAfterNumber = element.charAt(element.length() - 1);

            if (Character.isUpperCase(letterBeforeNumber)) {
                number = number / getPositionOfLetterInAlphabet(letterBeforeNumber);
            } else {
                number = number * getPositionOfLetterInAlphabet(letterBeforeNumber);
            }
            if (Character.isUpperCase(letterAfterNumber)) {
                number = number - getPositionOfLetterInAlphabet(letterAfterNumber);
            } else {
                number = number + getPositionOfLetterInAlphabet(letterAfterNumber);
            }

            sum += number;
        }

        System.out.printf("%.2f", sum);
    }

    static int getPositionOfLetterInAlphabet(char letter) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.indexOf(Character.toString(letter).toLowerCase()) + 1;
    }
}
