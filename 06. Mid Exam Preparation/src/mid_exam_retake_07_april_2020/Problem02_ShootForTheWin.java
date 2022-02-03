package mid_exam_retake_07_april_2020;

import java.util.Scanner;

public class Problem02_ShootForTheWin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getArrayOfNumbers(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();
        int shotTargets = 0;

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if (isValidIndex(numbers, index)) {
                int currentTarget = numbers[index];
                shotTargets++;

                if (currentTarget != -1) {
                    numbers[index] = -1;
                }
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] != -1) {
                        if (numbers[i] > currentTarget) {
                            numbers[i] -= currentTarget;
                        } else {
                            numbers[i] += currentTarget;
                        }
                    }

                }
            }
            input = scanner.nextLine();
        }
        printShotTargets(numbers, shotTargets);
    }

    static void printShotTargets(int[] array, int countOfShotTargets) {
        System.out.printf("Shot targets: %d -> ", countOfShotTargets);
        for (int element : array) {
            System.out.printf("%d ", element);
        }
    }

    static boolean isValidIndex(int[] array, int index) {
        return index >= 0 && index < array.length;
    }

    static int[] getArrayOfNumbers(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}