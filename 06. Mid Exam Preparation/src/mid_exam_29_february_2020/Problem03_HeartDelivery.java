package mid_exam_29_february_2020;

import java.util.Scanner;

public class Problem03_HeartDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] neighborhood = getArrayOfNumbers(scanner.nextLine().split("@"));
        String input = scanner.nextLine();
        int currentPosition = 0;


        while (!input.equals("Love!")) {
            int jump = Integer.parseInt(input.split("\\s+")[1]);
            currentPosition = currentPosition + jump;

            if (currentPosition > neighborhood.length - 1) {
                currentPosition = 0;
            }
            neighborhood[currentPosition] -= 2;
            if (neighborhood[currentPosition] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", currentPosition);
            }
            if (neighborhood[currentPosition] < 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", currentPosition);
        if (isMissionSuccessful(neighborhood)) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", getFailedPlaces(neighborhood));
        }
    }

    static boolean isMissionSuccessful(int[] array) {
        boolean isSuccessful = true;
        for (int element : array) {
            if (element > 0) {
                isSuccessful = false;
                break;
            }
        }
        return isSuccessful;
    }

    static int getFailedPlaces(int[] array) {
        int failedPlaces = 0;
        for (int element : array) {
            if (element > 0) {
                failedPlaces++;
            }
        }
        return failedPlaces;
    }

    static int[] getArrayOfNumbers(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}