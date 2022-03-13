package lab_tasks;

import java.util.Scanner;

public class Lab03_Substring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String word = scanner.nextLine();

        while (word.contains(input)) {
            word = word.replace(input, "");
        }
        System.out.println(word);
    }
}
