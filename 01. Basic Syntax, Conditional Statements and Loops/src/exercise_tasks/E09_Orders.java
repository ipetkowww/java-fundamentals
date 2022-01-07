package exercise_tasks;

import java.util.Scanner;

public class E09_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ordersCount = Integer.parseInt(scanner.nextLine());
        double orderPrice;
        double totalPrice = 0;

        for (int i = 1; i <= ordersCount; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int daysInMonth  = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());
            orderPrice = ((daysInMonth * capsuleCount) * pricePerCapsule);

            System.out.printf("The price for the coffee is: $%.2f%n", orderPrice);
            totalPrice += orderPrice;
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}