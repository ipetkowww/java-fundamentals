package exercise_tasks;

import java.util.Scanner;

public class E02_VowelsCount {

    public static void main(String[] args) {
        //a, e, i, o, and u
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int vowelsCount = getVowelsCount(input);
        System.out.println(vowelsCount);
    }

    static int getVowelsCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    static boolean isVowel(char letter) {
        boolean isVowel = false;
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char currentLetter : vowels) {
            if (currentLetter == letter) {
                isVowel = true;
                break;
            }
        }
        return isVowel;
    }
}