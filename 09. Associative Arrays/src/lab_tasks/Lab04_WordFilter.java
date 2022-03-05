package lab_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lab04_WordFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");

        Arrays.stream(words)
                .filter(w -> w.length() % 2 == 0)
                .forEach(System.out::println);
    }
}