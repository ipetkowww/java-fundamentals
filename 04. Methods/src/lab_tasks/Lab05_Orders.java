package lab_tasks;

import java.util.Scanner;

public class Lab05_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = scanner.nextInt();
        printTotalPrice(product, quantity);
    }

    static void printTotalPrice(String product, int quantity) {
        double totalPrice = calculateTotalPrice(product, quantity);
        System.out.printf("%.2f", totalPrice);
    }

    static double calculateTotalPrice(String product, int quantity) {
        double productPrice = getProductPrice(product);
        return productPrice * quantity;
    }

    static double getProductPrice(String product) {
        switch (product) {
            case "coffee":
                return 1.50;
            case "water":
                return 1.00;
            case "coke":
                return 1.40;
            case "snacks":
                return 2.00;
            default:
                return 0;
        }
    }
}