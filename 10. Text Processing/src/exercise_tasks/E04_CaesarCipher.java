package exercise_tasks;

import java.util.Scanner;

public class E04_CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char newChar = (char) (currentChar + 3);
            encryptedText.append(newChar);
        }
        System.out.println(encryptedText);
    }
}
