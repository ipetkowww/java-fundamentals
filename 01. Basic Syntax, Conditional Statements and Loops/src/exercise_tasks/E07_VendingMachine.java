package exercise_tasks;

import java.util.Scanner;

public class E07_VendingMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double insertedCoins = 0;

        while (!command.equals("Start")) {
            double coin = Double.parseDouble(command);
            if (isValidCoin(coin)) {
                insertedCoins += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            command = scanner.nextLine();
        }
        String productName = scanner.nextLine();

        while (!productName.equals("End")) {
            if (isValidProduct(productName)) {

                double productPrice = getProductPrice(productName);
                if (productPrice > insertedCoins) {
                    System.out.println("Sorry, not enough money");
                } else {
                    insertedCoins -= productPrice;
                    System.out.printf("Purchased %s%n", productName);
                }
            } else {
                System.out.println("Invalid product");
            }
            productName = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", insertedCoins);
    }

    static boolean isValidCoin(double coin) {
        return coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2;
    }

    static boolean isValidProduct(String productName) {
        return productName.equals("Nuts") || productName.equals("Water") || productName.equals("Crisps") ||
                productName.equals("Soda") || productName.equals("Coke");
    }

    static double getProductPrice(String productName) {
        switch (productName) {
            case "Nuts":
                return 2.0;
            case "Water":
                return 0.7;
            case "Crisps":
                return 1.5;
            case "Soda":
                return 0.8;
            case "Coke":
                return 1.0;
            default:
                return 0;
        }
    }
}