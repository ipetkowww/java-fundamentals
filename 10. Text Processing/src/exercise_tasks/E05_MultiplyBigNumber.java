package exercise_tasks;

import java.math.BigInteger;
import java.util.Scanner;

public class E05_MultiplyBigNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        int digit = Integer.parseInt(scanner.nextLine());

        BigInteger multiply = firstNumber.multiply(BigInteger.valueOf(digit));
        System.out.println(multiply);
    }
}
