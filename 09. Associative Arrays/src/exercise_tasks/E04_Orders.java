package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E04_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Product> productPrices = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] productInfo = input.split("\\s+");
            String productName = productInfo[0];
            double price = Double.parseDouble(productInfo[1]);
            int quantity = Integer.parseInt(productInfo[2]);
            Product product = new Product(price, quantity);

            Product currentProduct = productPrices.get(productName);
            if (currentProduct == null) {
                productPrices.put(productName, product);
            } else {
                productPrices.get(productName).setQuantity(currentProduct.getQuantity() + quantity);
                if (productPrices.get(productName).getPrice() != price) {
                    productPrices.get(productName).setPrice(price);
                }
            }
            input = scanner.nextLine();
        }

        productPrices.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value.getQuantity() * value.getPrice()));
    }

    static class Product {
        private double price;
        private int quantity;

        public Product(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}