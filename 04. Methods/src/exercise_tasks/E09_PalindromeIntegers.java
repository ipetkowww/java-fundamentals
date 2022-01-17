package exercise_tasks;

import java.util.Scanner;

public class E09_PalindromeIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            int currentNumber = Integer.parseInt(input);

            int numberForCheck = currentNumber;
            StringBuilder numberAsString = new StringBuilder();
            while (numberForCheck > 0) {
                int lastDigit = numberForCheck % 10;
                numberAsString.append(lastDigit);
                numberForCheck /= 10;
            }
            boolean isPalindrome = currentNumber == Integer.parseInt(numberAsString.toString());
            System.out.println(isPalindrome);
            input = scanner.nextLine();
        }
    }
}