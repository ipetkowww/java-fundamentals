package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E04_ListOperation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfIntegers(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];

            switch (command) {
                case "Add":
                    int numberForAdd = Integer.parseInt(commandArgs[1]);
                    add(numberForAdd, numbers);
                    break;
                case "Insert":
                    int numberForInsert = Integer.parseInt(commandArgs[1]);
                    int positionForInsert = Integer.parseInt(commandArgs[2]);
                    if (isValid(positionForInsert, numbers)) {
                        insert(numberForInsert, positionForInsert, numbers);
                    } else {
                        printInvalidIndexMessage();
                    }
                    break;
                case "Remove":
                    int indexForRemove = Integer.parseInt(commandArgs[1]);
                    if (isValid(indexForRemove, numbers)) {
                        remove(indexForRemove, numbers);
                    } else {
                        printInvalidIndexMessage();
                    }
                    break;
                case "Shift":
                    String shiftType = commandArgs[1];
                    int count = Integer.parseInt(commandArgs[2]);
                    if (shiftType.equals("left")) {
                        leftShift(count, numbers);
                    } else {
                        rightShift(count, numbers);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printListElements(numbers);
    }

    static void printListElements(List<Integer> list) {
        for (Integer element : list) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }

    static void rightShift(int count, List<Integer> list) {
        for (int i = 0; i < count; i++) {
            int lastElement = list.get(list.size() - 1);
            list.add(0, lastElement);
            list.remove(list.size() - 1);
        }
    }

    static void leftShift(int count, List<Integer> list) {
        for (int i = 0; i < count; i++) {
            int firstElement = list.get(0);
            list.add(firstElement);
            list.remove(0);
        }
    }

    static void remove(int index, List<Integer> list) {
        list.remove(index);
    }

    static void insert(int number, int index, List<Integer> list) {
        list.add(index, number);
    }

    static void add(int number, List<Integer> list) {
        list.add(number);
    }

    static void printInvalidIndexMessage() {
        System.out.println("Invalid index");
    }

    static boolean isValid(int index, List<Integer> list) {
        return index >= 0 && index < list.size();
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}