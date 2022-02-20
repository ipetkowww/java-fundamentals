import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem03_DeckOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> deck = getListOfStrings(scanner.nextLine().split(", "));
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] commandArgs = scanner.nextLine().split(", ");
            String command = commandArgs[0];

            switch (command) {
                case "Add":
                    String carForAdd = commandArgs[1];
                    if (deck.contains(carForAdd)) {
                        System.out.println("Card is already in the deck");
                    } else {
                        deck.add(carForAdd);
                        System.out.println("Card successfully added");
                    }
                    break;
                case "Remove":
                    String cardForRemove = commandArgs[1];
                    if (!deck.contains(cardForRemove)) {
                        System.out.println("Card not found");
                    } else {
                        deck.remove(cardForRemove);
                        System.out.println("Card successfully removed");
                    }
                    break;
                case "Remove At":
                    int indexForRemove = Integer.parseInt(commandArgs[1]);
                    if (indexForRemove < 0 || indexForRemove > deck.size() - 1) {
                        System.out.println("Index out of range");
                    } else {
                        deck.remove(indexForRemove);
                        System.out.println("Card successfully removed");
                    }
                    break;
                case "Insert":
                    int indexInsert = Integer.parseInt(commandArgs[1]);
                    String card = commandArgs[2];
                    if (indexInsert < 0 || indexInsert > deck.size() - 1) {
                        System.out.println("Index out of range");
                    } else {
                        if (deck.contains(card)) {
                            System.out.println("Card is already added");
                        } else {
                            deck.add(indexInsert, card);
                            System.out.println("Card successfully added");
                        }
                    }
                    break;
            }
        }
        System.out.println(String.join(", ", deck));
    }
    
    static List<String> getListOfStrings(String[] array) {
        List<String> result = new ArrayList<>();
        Collections.addAll(result, array);
        return result;
    }
}
