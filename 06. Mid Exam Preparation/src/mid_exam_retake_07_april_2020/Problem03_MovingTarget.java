package mid_exam_retake_07_april_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem03_MovingTarget {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfNumbers(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];
            int index = Integer.parseInt(commandArgs[1]);

            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(commandArgs[2]);
                    shoot(numbers, index, power);
                    break;
                case "Add":
                    int value = Integer.parseInt(commandArgs[2]);
                    boolean isAdded = add(numbers, index, value);
                    if (!isAdded) {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(commandArgs[2]);
                    boolean strike = strike(numbers, index, radius);
                    if (!strike) {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printTargets(numbers);
    }

    static void printTargets(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print("|");
            }
        }
    }

    static boolean strike(List<Integer> list, int index, int radius) {
        if (index - radius < 0 || index + radius > list.size()) {
            return false;
        }
        int target = list.get(index);
        for (int i = index; i < index + radius; i++) {
            list.remove(i + 1);
        }
        for (int i = index; i > index - radius; i--) {
            list.remove(i - 1);
        }
        list.remove(Integer.valueOf(target));
        return true;
    }

    static boolean add(List<Integer> list, int index, int value) {
        boolean isAdded = false;
        if (isValidIndex(list, index)) {
            list.add(index, value);
            isAdded = true;
        }
        return isAdded;
    }

    static void shoot(List<Integer> list, int index, int power) {
        if (isValidIndex(list, index)) {
            int valueAfterShoot = list.get(index) - power;
            if (valueAfterShoot <= 0) {
                list.remove(index);
            } else {
                list.set(index, valueAfterShoot);
            }
        }
    }

    static boolean isValidIndex(List<Integer> list, int index) {
        return index >= 0 && index < list.size();
    }

    static List<Integer> getListOfNumbers(String[] array) {
        List<Integer> result = new ArrayList<>();
        for (String element : array) {
            result.add(Integer.parseInt(element));
        }
        return result;
    }
}