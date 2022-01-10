package exercise_tasks;

import java.util.Scanner;

public class E09_KaminoFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int bestSequenceSum = 0;
        int bestSequenceIndex = 0;
        int count = 0;
        int sequenceIndex = length;
        int[] dnaSequence = new int[length];

        while (!command.equals("Clone them!")) {
            int[] arr = getArrayOfIntegers(command.split("!+"));
            int sum = 0;
            int index = length;
            count++;

            for (int i = 0; i < arr.length; i++) {
                if ((i != arr.length - 1) && arr[i] == 1 && arr[i + 1] == 1 && index == length) {
                    index = i;
                }
                sum += arr[i];
            }
            if (index == sequenceIndex && sum > bestSequenceSum) {
                dnaSequence = arr;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
            } else if (index < sequenceIndex) {
                dnaSequence = arr;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;
            }
            command = scanner.nextLine();
        }
        if (bestSequenceSum == 0) {
            bestSequenceIndex = 1;
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, bestSequenceSum);
        for (int value : dnaSequence) {
            System.out.print(value + " ");
        }
    }

    static int[] getArrayOfIntegers(String[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }
}