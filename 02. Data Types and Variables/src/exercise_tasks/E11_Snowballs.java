package exercise_tasks;

import java.util.Scanner;

public class E11_Snowballs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int snowballCounts = Integer.parseInt(scanner.nextLine());
        double snowballValue = 0;
        double maxSnowballValue = 0;
        int snowballSnowOut = 0;
        int snowballTimeOut = 0;
        int snowballQualityOut = 0;

        for (int i = 0; i < snowballCounts; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            snowballValue = Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);

            if (snowballValue > maxSnowballValue) {
                maxSnowballValue = snowballValue;
                snowballSnowOut = snowballSnow;
                snowballTimeOut = snowballTime;
                snowballQualityOut = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", snowballSnowOut, snowballTimeOut, maxSnowballValue, snowballQualityOut);
    }
}