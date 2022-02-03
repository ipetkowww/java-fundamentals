package mid_exam_retake_07_april_2020;

import java.util.Scanner;

public class Problem01_CounterStrike {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int wonBattle = 0;
        boolean enoughEnergy = true;

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End of battle")) {
                break;
            }
            int distance = Integer.parseInt(input);

            if (distance <= energy) {
                energy -= distance;
                wonBattle++;
                if (wonBattle % 3 == 0) {
                    energy += wonBattle;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", wonBattle, energy);
                enoughEnergy = false;
                break;
            }
        }
        if (enoughEnergy) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattle, energy);
        }
    }
}