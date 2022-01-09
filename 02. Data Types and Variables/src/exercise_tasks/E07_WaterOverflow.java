package exercise_tasks;

import java.util.Scanner;

public class E07_WaterOverflow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int waterTankCapacity = 255;
        int waterInTank = 0;

        for (int i = 0; i < lines; i++) {
            int waterLiters = Integer.parseInt(scanner.nextLine());

            if (waterTankCapacity < waterLiters) {
                System.out.println("Insufficient capacity!");
            } else {
                waterInTank += waterLiters;
                waterTankCapacity -= waterLiters;
            }
        }
        System.out.println(waterInTank);
    }
}