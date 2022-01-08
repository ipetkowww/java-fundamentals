package lab_tasks;

import java.math.BigDecimal;
import java.util.Scanner;

public class L03_ExactSumOfRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i < numbersCount; i++) {
            BigDecimal number = new BigDecimal(scanner.nextLine());
            sum = sum.add(number);
        }
        System.out.println(sum);
    }
}