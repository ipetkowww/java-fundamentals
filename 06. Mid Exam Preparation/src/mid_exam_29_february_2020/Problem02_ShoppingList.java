package mid_exam_29_february_2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem02_ShoppingList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> products = getListOfStrings(scanner.nextLine().split("!"));
        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];
            String item = commandArgs[1];

            switch (command) {
                case "Urgent":
                    addItemInTheBeginningOf(products, item);
                    break;
                case "Unnecessary":
                    removeItem(products, item);
                    break;
                case "Correct":
                    String newItem = commandArgs[2];
                    changeItem(products, item, newItem);
                    break;
                case "Rearrange":
                    moveItemToTheEndOf(products, item);
                    break;
            }
            input = scanner.nextLine();
        }
        printElementsOf(products);
    }

    static void printElementsOf(List<String> list) {
        System.out.println(String.join(", ", list));
    }

    static void moveItemToTheEndOf(List<String> list, String item) {
        if (isItemExist(list, item)) {
            list.remove(item);
            list.add(item);
        }
    }

    static void changeItem(List<String> list, String oldItem, String newItem) {
        if (isItemExist(list, oldItem)) {
            int indexOfOldItem = list.indexOf(oldItem);
            list.set(indexOfOldItem, newItem);
        }
    }

    static void removeItem(List<String> list, String item) {
        if (isItemExist(list, item)) {
            list.remove(item);
        }
    }

    static void addItemInTheBeginningOf(List<String> list, String item) {
        if (!isItemExist(list, item)) {
            list.add(0, item);
        }
    }

    static boolean isItemExist(List<String> list, String item) {
        return list.contains(item);
    }

    static List<String> getListOfStrings(String[] array) {
        List<String> result = new ArrayList<>();
        Collections.addAll(result, array);
        return result;
    }
}