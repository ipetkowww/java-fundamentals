package lab_tasks;

import java.util.Scanner;

public class Lab09_SumOfOddNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int oddNumberCount = 0;
        int oddNumber = 1;
        int sum = 0;

        while (oddNumberCount < number) {
            System.out.println(oddNumber);
            sum += oddNumber;
            oddNumberCount++;
            oddNumber += 2;
        }
        System.out.printf("Sum: %d", sum);
    }
}