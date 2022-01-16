package lab_tasks;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab08_MathPower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        int power = scanner.nextInt();
        double mathPowerOfNumber = getMathPowerOf(number, power);
        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(mathPowerOfNumber));
    }

    static double getMathPowerOf(double number, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }
}