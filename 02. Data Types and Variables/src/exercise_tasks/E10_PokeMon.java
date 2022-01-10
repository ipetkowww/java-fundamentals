package exercise_tasks;

import java.util.Scanner;

public class E10_PokeMon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine()); // N
        int distance = Integer.parseInt(scanner.nextLine()); // M
        int exhaustionFactor = Integer.parseInt(scanner.nextLine()); // Y
        int currentPokePower = pokePower;
        int targetCount = 0;

        while (currentPokePower >= distance) {
            currentPokePower -= distance;
            targetCount++;
            if (currentPokePower == pokePower * 0.5 && exhaustionFactor != 0) {
                currentPokePower /= exhaustionFactor;
            }

        }
        System.out.println(currentPokePower);
        System.out.println(targetCount);
    }
}