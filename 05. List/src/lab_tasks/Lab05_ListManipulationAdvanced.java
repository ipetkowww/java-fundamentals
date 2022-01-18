package lab_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab05_ListManipulationAdvanced {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfIntegers(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];


            switch (command) {
                case "Contains":
                    int numberForCheck = Integer.parseInt(commandArgs[1]);
                    String result = contains(numbers, numberForCheck) ? "Yes" : "No such number";
                    System.out.println(result);
                    break;
                case "Print":
                    String evenOrOdd = commandArgs[1];
                    if (evenOrOdd.equals("even")) {
                        printEven(numbers);
                    } else {
                        printOdd(numbers);
                    }
                    break;
                case "Get":
                    int sumOfElements = getSum(numbers);
                    System.out.println(sumOfElements);
                    break;
                case "Filter":
                    String condition = commandArgs[1];
                    int number = Integer.parseInt(commandArgs[2]);
                    List<Integer> filteredList = filter(numbers, condition, number);
                    printElementsOfList(filteredList);
            }
            input = scanner.nextLine();
        }
    }

    static List<Integer> filter(List<Integer> numbers, String condition, int number) {
        List<Integer> filteredList = new ArrayList<>();
        switch (condition) {
            case "<":
                filteredList = numbers.stream().filter(e -> e < number).collect(Collectors.toList());
                break;
            case ">":
                filteredList = numbers.stream().filter(e -> e > number).collect(Collectors.toList());
                break;
            case ">=":
                filteredList = numbers.stream().filter(e -> e >= number).collect(Collectors.toList());
                break;
            case "<=":
                filteredList = numbers.stream().filter(e -> e <= number).collect(Collectors.toList());
                break;
        }
        return filteredList;
    }

    static int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            sum += element;
        }
        return sum;
    }

    private static void printOdd(List<Integer> list) {
        List<Integer> oddElements = new ArrayList<>();
        for (Integer element : list) {
            if (element % 2 != 0) {
                oddElements.add(element);
            }
        }
        printElementsOfList(oddElements);
    }

    static void printEven(List<Integer> list) {
        List<Integer> evenElements = new ArrayList<>();
        for (Integer element : list) {
            if (element % 2 == 0) {
                evenElements.add(element);
            }
        }
        printElementsOfList(evenElements);
    }

    static void printElementsOfList(List<Integer> list) {
        for (Integer element : list) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }

    static boolean contains(List<Integer> list, int number) {
        return list.contains(number);
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}