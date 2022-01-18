package lab_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab04_ListManipulationBasics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfIntegers(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();
        int number;
        int index;

        while (!input.equals("end")) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];

            switch (command) {
                case "Add":
                    number = Integer.parseInt(commandArgs[1]);
                    add(numbers, number);
                    break;
                case "Remove":
                    number = Integer.parseInt(commandArgs[1]);
                    removeNumber(numbers, number);
                    break;
                case "RemoveAt":
                    index = Integer.parseInt(commandArgs[1]);
                    removeAt(numbers, index);
                    break;
                case "Insert":
                    number = Integer.parseInt(commandArgs[1]);
                    index = Integer.parseInt(commandArgs[2]);
                    insert(numbers, number, index);
                    break;
            }
            input = scanner.nextLine();
        }
        printElementsOfList(numbers);
    }

    static void printElementsOfList(List<Integer> list) {
        for (Integer element : list) {
            System.out.printf("%d ", element);
        }
    }

    static void insert(List<Integer> list, int number, int index) {
        list.add(index, number);
    }

    static void removeAt(List<Integer> list, int index) {
        list.remove(index);
    }

    static void removeNumber(List<Integer> list, int number) {
        list.remove(Integer.valueOf(number));
    }

    static void add(List<Integer> list, int number) {
        list.add(number);
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}