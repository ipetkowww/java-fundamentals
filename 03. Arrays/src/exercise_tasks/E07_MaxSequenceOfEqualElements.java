package exercise_tasks;

import java.util.Scanner;

public class E07_MaxSequenceOfEqualElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getArrayOfIntegers(scanner.nextLine().split("\\s+"));
        int sequenceElement = numbers[0];
        int maxSequence = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentElement = numbers[i];
            int sequenceCount = 1;

            for (int j = i + 1; j < numbers.length; j++) {
                if (currentElement == numbers[j]) {
                    sequenceCount++;
                } else {
                    break;
                }
            }
            if (sequenceCount > maxSequence) {
                maxSequence = sequenceCount;
                sequenceElement = currentElement;
            }
        }
        for (int i = 0; i < maxSequence; i++) {
            System.out.printf("%d ", sequenceElement);
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