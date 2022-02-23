package lab_tasks;

import java.math.BigInteger;
import java.util.Scanner;

public class Lab02_SumBigNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        BigInteger secondNumber = new BigInteger(scanner.nextLine());

        System.out.println(firstNumber.add(secondNumber));
    }
}
