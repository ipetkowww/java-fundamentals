package lab_tasks;

import java.util.Scanner;

public class Lab02_RepeatStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        StringBuilder appendWords = new StringBuilder();

        for (String currentWord : words) {
            appendWords.append(currentWord.repeat(currentWord.length()));
        }
        System.out.println(appendWords);
    }
}
