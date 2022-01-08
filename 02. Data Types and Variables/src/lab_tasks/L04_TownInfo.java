package lab_tasks;

import java.util.Scanner;

public class L04_TownInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String town = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int area = Integer.parseInt(scanner.nextLine());

        System.out.printf("Town %s has population of %s and area %s square km.", town, population, area);
    }
}