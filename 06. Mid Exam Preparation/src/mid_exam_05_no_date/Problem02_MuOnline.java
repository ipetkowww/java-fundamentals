package mid_exam_05_no_date;

import java.util.Scanner;

public class Problem02_MuOnline {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rooms = scanner.nextLine().split("\\|");
        int initialHealth = 100;
        int bitcoins = 0;
        boolean gameOver = false;

        for (int i = 0; i < rooms.length; i++) {
            String[] currentRoom = rooms[i].split("\\s+");
            String command = currentRoom[0];
            int points = Integer.parseInt(currentRoom[1]);

            switch (command) {
                case "potion":
                    int healed;
                    if (initialHealth + points > 100) {
                        healed = 100 - initialHealth;
                    } else {
                        healed = points;
                    }
                    initialHealth += healed;
                    System.out.printf("You healed for %d hp.%n", healed);
                    System.out.printf("Current health: %d hp.%n", initialHealth);
                    break;
                case "chest":
                    System.out.printf("You found %d bitcoins.%n", points);
                    bitcoins += points;
                    break;
                default:
                    if (initialHealth > points) {
                        System.out.printf("You slayed %s.%n", command);
                        initialHealth -= points;
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", i + 1);
                        gameOver = true;
                    }
                    break;
            }
            if (gameOver) {
                break;
            }
        }
        if (!gameOver) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", initialHealth);
        }
    }
}