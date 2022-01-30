package mid_exam_retake_12_august_2020;

import java.util.Scanner;

public class Problem01_ComputerStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double priceWithoutTaxes = 0;
        double taxes = 0;
        double totalPrice = 0;

        while (!(input.equals("special") || input.equals("regular"))) {
            double partPrice = Double.parseDouble(input);

            if (partPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                priceWithoutTaxes += partPrice;
                taxes += partPrice * 0.2;
            }

            input = scanner.nextLine();
        }

        totalPrice = priceWithoutTaxes + taxes;
        if (input.equals("special")) {
            totalPrice -= totalPrice * 0.1;
        }

        if (totalPrice <= 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }
    }
}