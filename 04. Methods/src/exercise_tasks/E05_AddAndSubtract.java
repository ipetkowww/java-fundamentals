package exercise_tasks;

import java.util.Scanner;

public class E05_AddAndSubtract {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();
        System.out.println(getResult(firstNum, secondNum, thirdNum));
    }

    static int getResult(int firstNum, int secondNum, int thirdNum) {
        int resultOfSum = sum(firstNum, secondNum);
        return subtract(resultOfSum, thirdNum);
    }

    static int subtract(int numberX, int numberY) {
        return numberX - numberY;
    }

    static int sum(int numberX, int numberY) {
        return numberX + numberY;
    }
}