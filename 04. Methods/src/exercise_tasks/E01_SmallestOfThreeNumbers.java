package exercise_tasks;

import java.util.Scanner;

public class E01_SmallestOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();
        System.out.println(getSmallestOfThreeNumbers(firstNum, secondNum, thirdNum));
    }

    static int getSmallestOfThreeNumbers(int firstNum, int secondNum, int thirdNum) {
        int smallest = 0;
        if (firstNum < secondNum && firstNum < thirdNum) {
            smallest = firstNum;
        } else if (secondNum < firstNum && secondNum < thirdNum) {
            smallest = secondNum;
        } else {
            smallest = thirdNum;
        }
        return smallest;
    }
}