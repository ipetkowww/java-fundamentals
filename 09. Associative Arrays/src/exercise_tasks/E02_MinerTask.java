package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02_MinerTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> resourceQuantyties = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            Integer resourceQuantity = resourceQuantyties.get(resource);
            if (resourceQuantity == null) {
                resourceQuantity = 0;
            }
            resourceQuantyties.put(resource, resourceQuantity + quantity);
            input = scanner.nextLine();
        }
        resourceQuantyties.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}