package exercise_tasks;

import java.util.Scanner;

public class E08_BeerKegs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        double biggestVolume = Double.MIN_VALUE;
        String biggestModel = "";

        for (int i = 0; i < lines; i++) {
            String beerKegModel = scanner.nextLine();
            double beerKegRadius = Double.parseDouble(scanner.nextLine());
            int beerKegHeight = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * (beerKegRadius * beerKegRadius) * beerKegHeight;
            if (volume > biggestVolume) {
                biggestVolume = volume;
                biggestModel = beerKegModel;
            }
        }
        System.out.println(biggestModel);
    }
}