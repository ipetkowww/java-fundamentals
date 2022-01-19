package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06_CardsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerDeck = getListOfIntegers(scanner.nextLine().split("\\s+"));
        List<Integer> secondPlayerDeck = getListOfIntegers(scanner.nextLine().split("\\s+"));

        while (true) {
            int firstPlayerCard = firstPlayerDeck.get(0);
            int secondPlayerCard = secondPlayerDeck.get(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
                firstPlayerDeck.remove(Integer.valueOf(firstPlayerCard));
                secondPlayerDeck.remove(Integer.valueOf(secondPlayerCard));
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(secondPlayerCard);
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.remove(Integer.valueOf(secondPlayerCard));
                firstPlayerDeck.remove(Integer.valueOf(firstPlayerCard));
            } else {
                firstPlayerDeck.remove(Integer.valueOf(firstPlayerCard));
                secondPlayerDeck.remove(Integer.valueOf(secondPlayerCard));
            }

            if (firstPlayerDeck.isEmpty()) {
                System.out.printf("Second player wins! Sum: %d", getSumOfCards(secondPlayerDeck));
                break;
            }

            if (secondPlayerDeck.isEmpty()) {
                System.out.printf("First player wins! Sum: %d", getSumOfCards(firstPlayerDeck));
                break;
            }
        }

    }

    static int getSumOfCards(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            sum += element;
        }
        return sum;
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}