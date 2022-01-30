package mid_exam_retake_12_august_2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem03_MemoryGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> sequence = getListOfIntegers(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();
        int moves = 0;
        boolean gameOver = false;

        while (!input.equals("end")) {
            moves++;

            String[] indexes = input.split("\\s+");
            int firstIndex = Integer.parseInt(indexes[0]);
            int secondIndex = Integer.parseInt(indexes[1]);
            boolean firstIndexValid = isValidIndex(sequence, firstIndex);
            boolean secondIndexValid = isValidIndex(sequence, secondIndex);
            boolean indexesEquals = areEquals(firstIndex, secondIndex);

            if (firstIndexValid && secondIndexValid && !indexesEquals) {
                if (sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(firstIndex));
                    sequence.removeIf(e -> e.equals(sequence.get(firstIndex)));
                } else {
                    System.out.println("Try again!");
                }

                if (sequence.isEmpty()) {
                    System.out.printf("You have won in %d turns!%n", moves);
                    gameOver = true;
                    break;
                }
            } else {
                System.out.println("Invalid input! Adding additional elements to the board");
                sequence.add(sequence.size() / 2, String.format("-%sa", moves));
                sequence.add(sequence.size() / 2, String.format("-%sa", moves));
            }
            input = scanner.nextLine();
        }

        if (!gameOver) {
            System.out.println("Sorry you lose :(");
            printList(sequence);
        }
    }

    static List<String> getListOfIntegers(String[] array) {
        List<String> result = new ArrayList<>();
        Collections.addAll(result, array);
        return result;
    }

    static boolean areEquals(int index1, int index2) {
        return index1 == index2;
    }

    static boolean isValidIndex(List<String> list, int index) {
        return index >= 0 && index < list.size();
    }

    static void printList(List<String> list) {
        for (String item : list) {
            System.out.printf("%s ", item);
        }
    }
}