package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_ChangeList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfIntegers(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];
            int element = Integer.parseInt(commandArgs[1]);
            switch (command) {
                case "Delete":
                    delete(element, numbers);
                    break;
                case "Insert":
                    int position = Integer.parseInt(commandArgs[2]);
                    insert(element, position, numbers);
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

    static void insert(int element, int position, List<Integer> list) {
        list.add(position, element);
    }

    static void delete(int number, List<Integer> list) {
        list.removeIf(e -> e == number);
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}