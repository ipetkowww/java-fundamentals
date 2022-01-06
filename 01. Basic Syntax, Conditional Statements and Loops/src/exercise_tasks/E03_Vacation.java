package exercise_tasks;

import java.util.Scanner;

public class E03_Vacation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupCount = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double price = 0;

        switch (groupType) {
            case "Students":
                switch (dayOfWeek) {
                    case "Friday":
                        price = 8.45 * groupCount;
                        break;
                    case "Saturday":
                        price = 9.8 * groupCount;
                        break;
                    case "Sunday":
                        price = 10.46 * groupCount;
                        break;
                }
                if (groupCount >= 30) {
                    price -= price * 0.15;
                }
                break;
            case "Business":
                if (groupCount >= 100) {
                    groupCount -= 10;
                }
                switch (dayOfWeek) {
                    case "Friday":
                        price = 10.90 * groupCount;
                        break;
                    case "Saturday":
                        price = 15.6 * groupCount;
                        break;
                    case "Sunday":
                        price = 16 * groupCount;
                        break;
                }
                break;
            case "Regular":
                switch (dayOfWeek) {
                    case "Friday":
                        price = 15 * groupCount;
                        break;
                    case "Saturday":
                        price = 20 * groupCount;
                        break;
                    case "Sunday":
                        price = 22.50 * groupCount;
                        break;
                }
                if (groupCount >= 10 && groupCount <= 20) {
                    price -= price * 0.05;
                }
                break;
        }
        System.out.printf("Total price: %.2f", price);
    }
}