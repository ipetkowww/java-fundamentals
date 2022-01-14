package exercise_tasks;

import java.util.Scanner;

public class E10_LadyBugs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] initialIndexes = getArrayOfIntegers(scanner.nextLine().split("\\s+"));
        String command = scanner.nextLine();

        int[] field = new int[fieldSize];
        for (int currentElement : initialIndexes) {
            if (currentElement >= 0 && currentElement < field.length) {
                field[currentElement] = 1;
            }
        }

        while (!command.equals("end")) {
            String[] splitCommand = command.split("\\s+");

            int ladyBugIndex = Integer.parseInt(splitCommand[0]);
            String direction = splitCommand[1];
            int flyLength = Integer.parseInt(splitCommand[2]);

            if (ladyBugIndex < 0 || ladyBugIndex > fieldSize - 1 || field[ladyBugIndex] == 0) {
                command = scanner.nextLine();
                continue;
            }

            field[ladyBugIndex] = 0;
            if (direction.equals("right")) {
                ladyBugIndex += flyLength;

                while (ladyBugIndex < fieldSize && field[ladyBugIndex] == 1) {
                    ladyBugIndex += flyLength;
                }
                if (ladyBugIndex < fieldSize) {
                    field[ladyBugIndex] = 1;
                }
            } else {
                ladyBugIndex -= flyLength;
                while (ladyBugIndex >= 0 && field[ladyBugIndex] == 1) {
                    ladyBugIndex -= flyLength;
                }
                if (ladyBugIndex >= 0) {
                    field[ladyBugIndex] = 1;
                }
            }
            command = scanner.nextLine();
        }

        for (int cell : field) {
            System.out.printf("%d ", cell);
        }
    }

    static int[] getArrayOfIntegers(String[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}