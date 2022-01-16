package lab_tasks;

import java.util.Scanner;

public class Lab09_GreaterOfTwoValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type) {
            case "int":
                int firstNum = scanner.nextInt();
                int secondNum = scanner.nextInt();
                System.out.println(getMax(firstNum, secondNum));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstChar, secondChar));
                break;
            case "string":
                String firstStr = scanner.nextLine();
                String secondStr = scanner.nextLine();
                System.out.println(getMax(firstStr, secondStr));
                break;
        }
    }

    static int getMax(int firstNum, int secondNum) {
        return Math.max(firstNum, secondNum);
    }

    static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        }
        return secondChar;
    }

    static String getMax(String firstStr, String secondStr) {
        if (firstStr.compareTo(secondStr) >= 0) {
            return firstStr;
        }
        return secondStr;
    }
}