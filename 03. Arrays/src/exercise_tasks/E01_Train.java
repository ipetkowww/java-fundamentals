package exercise_tasks;

import java.util.Scanner;

public class E01_Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagonsCount = Integer.parseInt(scanner.nextLine());
        int[] train = new int[wagonsCount];
        int allPeopleInTrain = 0;

        for (int i = 0; i < wagonsCount; i++) {
            int peopleCount = Integer.parseInt(scanner.nextLine());
            train[i] = peopleCount;
            allPeopleInTrain += peopleCount;
        }

        for (int wagon : train) {
            System.out.printf("%d ", wagon);
        }
        System.out.printf("%n%d", allPeopleInTrain);
    }
}