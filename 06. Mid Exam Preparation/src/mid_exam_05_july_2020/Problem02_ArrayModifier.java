package mid_exam_05_july_2020;

import java.util.Scanner;

public class Problem02_ArrayModifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getArrayNumbers(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];
            switch (command) {
                case "swap":
                    int swapIndex1 = Integer.parseInt(commandArgs[1]);
                    int swapIndex2 = Integer.parseInt(commandArgs[2]);
                    swap(numbers, swapIndex1, swapIndex2);
                    break;
                case "multiply":
                    int multiplyIndex1 = Integer.parseInt(commandArgs[1]);
                    int multiplyIndex2 = Integer.parseInt(commandArgs[2]);
                    numbers[multiplyIndex1] = numbers[multiplyIndex1] * numbers[multiplyIndex2];
                    break;
                case "decrease":
                    decreaseAllElementsInArrayByOne(numbers);
                    break;
            }
            input = scanner.nextLine();
        }
        printElementsOfArray(numbers);
    }

    static void printElementsOfArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
    }

    static void decreaseAllElementsInArrayByOne(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]--;
        }
    }

    static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    static int[] getArrayNumbers(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}