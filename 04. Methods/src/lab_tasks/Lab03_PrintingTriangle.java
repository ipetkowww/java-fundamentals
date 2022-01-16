package lab_tasks;

import java.util.Scanner;

public class Lab03_PrintingTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            printLine(1, i);
        }
        for (int j = 1; j <= n - 1; j++)
            printLine(1, n - j);
    }

    static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}