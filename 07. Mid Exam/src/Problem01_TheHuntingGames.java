import java.util.Scanner;

public class Problem01_TheHuntingGames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysOfAdventure = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double energy = Double.parseDouble(scanner.nextLine());
        double waterPerDay = Double.parseDouble(scanner.nextLine());
        double foodPerDay = Double.parseDouble(scanner.nextLine());

        double totalWater = daysOfAdventure * players * waterPerDay;
        double totalFood = daysOfAdventure * players * foodPerDay;
        boolean enoughEnergy = true;

        for (int i = 1; i <= daysOfAdventure; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            energy -= energyLoss;
            if (energy <= 0) {
                enoughEnergy = false;
                break;
            }
            if (i % 2 == 0) {
                energy += energy * 0.05;
                totalWater -= totalWater * 0.3;
            }
            if (i % 3 == 0) {
                totalFood -= (totalFood / players);
                energy += energy * 0.1;
            }
        }

        if (enoughEnergy) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!%n", energy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
        }
    }

}
