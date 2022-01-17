package exercise_tasks;

import java.util.Scanner;

public class E07_NxNMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printNxNMatrix(number);
    }

    static void printNxNMatrix(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");
            for (int j = 0; j < n - 1; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}