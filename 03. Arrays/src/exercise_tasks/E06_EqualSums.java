package exercise_tasks;

import java.util.Scanner;

public class E06_EqualSums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getArrayOfIntegers(scanner.nextLine().split("\\s+"));
        int sumRight = 0;
        for (int number : numbers) {
            sumRight += number;
        }

        int sumLeft = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumRight -= numbers[i];
            if(sumLeft == sumRight) {
                System.out.println(i);
                return;
            }
            sumLeft += numbers[i];
        }
        System.out.println("no");
    }

    static int[] getArrayOfIntegers(String[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }
}