package mid_exam_05_no_date;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem03_Inventory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = getListOfStrings(scanner.nextLine().split(", "));
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] commandArgs = input.split(" - ");
            String command = commandArgs[0];
            String item = commandArgs[1];

            switch (command) {
                case "Collect":
                    collect(items, item);
                    break;
                case "Drop":
                    drop(items, item);
                    break;
                case "Combine Items":
                    String[] splitItems = item.split(":");
                    String oldItem = splitItems[0];
                    String newItem = splitItems[1];
                    combineItems(items, oldItem, newItem);
                    break;
                case "Renew":
                    renew(items, item);
                    break;
            }
            input = scanner.nextLine();
        }
        printElementsOf(items);
    }

    static void printElementsOf(List<String> list) {
        System.out.println(String.join(", ", list));
    }

    static void renew(List<String> list, String item) {
        if (isItemExist(list, item)) {
            list.remove(item);
            list.add(item);
        }
    }

    static void combineItems(List<String> list, String oldItem, String newItem) {
        if (isItemExist(list, oldItem)) {
            list.add(list.indexOf(oldItem) + 1, newItem);
        }
    }

    static void drop(List<String> list, String item) {
        if (isItemExist(list, item)) {
            list.remove(item);
        }
    }

    static void collect(List<String> list, String item) {
        if (!isItemExist(list, item)) {
            list.add(item);
        }
    }

    static boolean isItemExist(List<String> list, String item) {
        return list.contains(item);
    }

    static List<String> getListOfStrings(String[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}