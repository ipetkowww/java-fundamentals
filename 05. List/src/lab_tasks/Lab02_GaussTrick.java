package lab_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab02_GaussTrick {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfIntegers(scanner.nextLine().split("\\s+"));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.size() / 2; i++) {
            int elementFromBegin = numbers.get(i);
            int elementFromEnd = numbers.get(numbers.size() - i - 1);
            result.add(elementFromBegin + elementFromEnd);
        }
        if (numbers.size() % 2 != 0) {
            result.add(numbers.get(numbers.size() / 2));
        }
        printElementsOfList(result);
    }

    static void printElementsOfList(List<Integer> list) {
        for (Integer element : list) {
            System.out.printf("%d ", element);
        }
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}