package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05_SoftUniParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> userCars = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String username = input[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = input[2];
                    String carNumber = userCars.get(username);
                    if (carNumber == null) {
                        userCars.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    }
                    break;
                case "unregister":
                    boolean isUsernameExist = userCars.containsKey(username);
                    if (isUsernameExist) {
                        userCars.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
            }
        }
        userCars.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
    }
}