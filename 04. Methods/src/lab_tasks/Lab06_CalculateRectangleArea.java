package lab_tasks;

import java.util.Scanner;

public class Lab06_CalculateRectangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();
        double areaOfRectangle = calculateRectangleArea(width, height);
        System.out.printf("%.0f", areaOfRectangle);
    }

    static double calculateRectangleArea(double width, double height) {
        return width * height;
    }
}