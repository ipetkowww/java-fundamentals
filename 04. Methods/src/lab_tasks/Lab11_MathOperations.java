package lab_tasks;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab11_MathOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());
        double result = calculate(firstNum, operation, secondNum);
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println(df.format(result));
    }

    static double calculate(int firstNum, String operation, int secondNum) {
        switch (operation) {
            case "/": return divide(firstNum, secondNum);
            case "*": return multiply(firstNum, secondNum);
            case "+": return add(firstNum, secondNum);
            case "-": return subtract(firstNum, secondNum);
            default: return 0;
        }
    }

    static double divide(int firstNum, int secondNum) {
        return firstNum * 1.0 / secondNum;
    }

    static double multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    static double add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    static double subtract(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}