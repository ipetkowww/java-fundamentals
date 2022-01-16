package lab_tasks;

import java.util.Scanner;

public class Lab01_SignOfInteger {

    public static void main(String[] args) {
        printSignOfInteger(new Scanner(System.in).nextInt());
    }

    static void printSignOfInteger(int number) {
        String result;
        if (number > 0) {
            result = "positive";
        } else {
            if (number < 0) {
                result = "negative";
            } else {
                result = "zero";
            }
        }
        System.out.printf("The number %d is %s.", number, result);
    }
}