package lab_tasks;

import java.util.Scanner;

public class Lab10_MultiplyEvensByOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int result = getResultOfMultiplicationOfEvensAndOdds(Math.abs(number));
        System.out.println(result);
    }

    static int getResultOfMultiplicationOfEvensAndOdds(int number) {
        int sumOfEvenNumbers = getSumOfEvenNumbers(number);
        int sumOfOddNumbers = getSumOfOddNumbers(number);
        return sumOfEvenNumbers * sumOfOddNumbers;
    }

    static int getSumOfEvenNumbers(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                sum += digit;
            }
            number /= 10;
        }
        return sum;
    }

    static int getSumOfOddNumbers(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                sum += digit;
            }
            number /= 10;
        }
        return sum;
    }
}