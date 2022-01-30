package mid_exam_retake_12_august_2020;

import java.util.Scanner;

public class Problem02_TheLift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = getNumbersArray(scanner.nextLine().split("\\s+"));
        int maxPeopleInWagon = 4;
        boolean peopleInQueue = true;

        if (people > 0) {
            for (int i = 0; i < lift.length; i++) {
                while (lift[i] < maxPeopleInWagon) {
                    lift[i]++;
                    people--;
                    if (people == 0) {
                        peopleInQueue = false;
                        break;
                    }
                }
                if (!peopleInQueue) {
                    break;
                }
            }
        }
        boolean full = isLiftFull(lift, maxPeopleInWagon);
        if (people == 0 && !full) {
            System.out.println("The lift has empty spots!");
        } else if (people > 0 && full) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }
        printArray(lift);
    }

    static int[] getNumbersArray(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }

    static void printArray(int[] array) {
        for (int item : array) {
            System.out.printf("%d ", item);
        }
    }

    static boolean isLiftFull(int[] liftState, int maxPeopleInWagon) {
        boolean isFull = true;
        for (int wagon : liftState) {
            if (wagon < maxPeopleInWagon) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
}