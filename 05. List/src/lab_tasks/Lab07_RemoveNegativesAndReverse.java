package lab_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab07_RemoveNegativesAndReverse {

    public static void main(String[] args) {
        List<Integer> numbers = getListOfIntegers(new Scanner(System.in).nextLine().split("\\s+"));
        List<Integer> listWithPositiveNumbersOnly = getListWithPositiveNumbersOnly(numbers);

        if (listWithPositiveNumbersOnly.isEmpty()) {
            System.out.println("empty");
        } else {
            printElementsReverse(listWithPositiveNumbersOnly);
        }
    }

    static void printElementsReverse(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.printf("%d ", list.get(i));
        }
    }

    static List<Integer> getListWithPositiveNumbersOnly(List<Integer> list) {
        List<Integer> positiveNums = new ArrayList<>();
        for (Integer element : list) {
            if (element >= 0) {
                positiveNums.add(element);
            }
        }
        return positiveNums;
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}