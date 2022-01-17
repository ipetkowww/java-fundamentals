package exercise_tasks;

import java.util.Scanner;

public class E08_FactorialDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long firstNumberFactorial = calculateFactorial(scanner.nextInt());
        long secondNumberFactorial = calculateFactorial(scanner.nextInt());
        System.out.printf("%.2f", firstNumberFactorial * 1.0 / secondNumberFactorial);
    }

    static long calculateFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}