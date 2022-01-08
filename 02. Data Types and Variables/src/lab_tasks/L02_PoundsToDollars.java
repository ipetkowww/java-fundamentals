package lab_tasks;

import java.math.BigDecimal;
import java.util.Scanner;

public class L02_PoundsToDollars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal britishPounds = new BigDecimal(scanner.nextLine());
        BigDecimal dollar = new BigDecimal("1.31");
        BigDecimal toDollars = britishPounds.multiply(dollar);

        System.out.printf("%.3f", toDollars);
    }
}