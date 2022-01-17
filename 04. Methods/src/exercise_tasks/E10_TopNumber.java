package exercise_tasks;

import java.util.Scanner;

public class E10_TopNumber {

    public static void main(String[] args) {
        printTopNumber(new Scanner(System.in).nextInt());
    }

    static void printTopNumber(int number) {
        for (int i = 1; i <= number; i++) {
            if (isSumOfDigitsDivisibleByEight(i) && isHoldAtLeastOneOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean isSumOfDigitsDivisibleByEight(int number) {
        int sumOfDigits = sumOfDigits(number);
        return sumOfDigits % 8 == 0;
    }

    static boolean isHoldAtLeastOneOddDigit(int number) {
        int oddDigitCount = 0;
        boolean isHoldOddDigit = false;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                oddDigitCount++;
            }
            if (oddDigitCount == 1) {
                isHoldOddDigit = true;
                break;
            }
            number /= 10;
        }
        return isHoldOddDigit;
    }

    static int sumOfDigits(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }
        return sumOfDigits;
    }
}