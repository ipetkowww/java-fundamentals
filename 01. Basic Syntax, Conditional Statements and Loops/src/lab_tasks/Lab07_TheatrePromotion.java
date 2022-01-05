package lab_tasks;

import java.util.Scanner;

public class Lab07_TheatrePromotion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double price = 0;

        if (age < 0 || age > 122) {
            System.out.println("Error!");
        } else {
            switch (day) {
                case "Weekday":
                    if ( (age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                        price = 12;
                    } else if (age > 18 && age <= 64) {
                        price = 18;
                    }
                    break;
                case "Weekend":
                    if ( (age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                        price = 15;
                    } else if (age > 18 && age <= 64) {
                        price = 20;
                    }
                    break;
                case "Holiday":
                    if ((age >= 0 && age <= 18)) {
                        price = 5;
                    } else if (age > 18 && age <= 64) {
                        price = 12;
                    } else if (age > 64 && age <= 122) {
                        price = 10;
                    }
                    break;
            }
            System.out.printf("%.0f$", price);
        }
    }
}