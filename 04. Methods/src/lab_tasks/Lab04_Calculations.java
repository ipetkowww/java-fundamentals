package lab_tasks;

import java.util.Scanner;

public class Lab04_Calculations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        switch (operation) {
            case "add":
                add(firstNumber, secondNumber);
                break;
            case "multiply":
                multiply(firstNumber, secondNumber);
                break;
            case "subtract":
                subtract(firstNumber, secondNumber);
                break;
            case "divide":
                divide(firstNumber, secondNumber);
                break;
        }
    }

    static void add(int firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }

    static void multiply(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    static void subtract(int firstNumber, int secondNumber) {
        System.out.println(firstNumber - secondNumber);
    }

    static void divide(int firstNumber, int secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }
}