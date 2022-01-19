package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E01_Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = getListOfIntegers(scanner.nextLine().split("\\s+"));
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int number;

        while (!input.equals("end")) {
            String[] commandArgs = input.split("\\s+");
            if (commandArgs.length > 1) {
                number = Integer.parseInt(commandArgs[1]);
                wagons.add(number);
            } else {
                number = Integer.parseInt(commandArgs[0]);

                for (int i = 0; i < wagons.size(); i++) {
                    int currentWagon = wagons.get(i);
                    if (currentWagon + number <= maxCapacity) {
                        wagons.set(i, currentWagon + number);
                        break;
                    }
                }

            }
            input = scanner.nextLine();
        }
        printListElements(wagons);
    }

    static void printListElements(List<Integer> list) {
        for (Integer element : list) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}