package mid_exam_29_february_2020;

import java.util.Scanner;

public class Problem01_GuineaPig {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double foodQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double hayQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double coverQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double guineaWeight = Double.parseDouble(scanner.nextLine()) * 1000;
        int day = 1;
        int foodPerDay = 300;

        while (day <= 30) {
            foodQuantity -= foodPerDay;

            if (day % 2 == 0) {
                double neededHay = foodQuantity * 0.05;
                hayQuantity -= neededHay;
            }
            if (day % 3 == 0) {
                coverQuantity -= guineaWeight / 3;
            }
            day++;
        }

        if (isEnough(foodQuantity) && isEnough(hayQuantity) && isEnough(coverQuantity)) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    foodQuantity / 1000, hayQuantity / 1000, coverQuantity / 1000);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }

    static boolean isEnough(double quantity) {
        return quantity > 0;
    }
}