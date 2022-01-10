package exercise_tasks;

import java.io.Console;
import java.util.Scanner;

public class E09_SpiceMustFlow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());

        int miningCrewConsumption = 26;
        int days = 0;
        int leavingSpices = 0;

        if (startingYield < 100) {
            System.out.println(days);
            System.out.println(leavingSpices);
        } else {
            while (startingYield >= 100) {
                days++;
                leavingSpices += startingYield - miningCrewConsumption;
                startingYield -= 10;
            }
            System.out.println(days);
            System.out.println(leavingSpices - miningCrewConsumption);
        }
    }
}