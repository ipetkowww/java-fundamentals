package lab_tasks;

import java.util.Scanner;

public class Lab04_TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWords) {
            text = text.replace(word, "*".repeat(word.length()));
        }
        System.out.println(text);
    }
}
