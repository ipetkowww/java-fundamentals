package lab_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab03_MergingLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = getListOfIntegers(scanner.nextLine().split("\\s+"));
        List<Integer> secondList = getListOfIntegers(scanner.nextLine().split("\\s+"));
        List<Integer> result = new ArrayList<>();
        int biggerListSize = Math.max(firstList.size(), secondList.size());

        for (int i = 0; i < biggerListSize; i++) {
            if (!firstList.isEmpty()) {
                result.add(firstList.get(0));
                firstList.remove(0);
            }
            if (!secondList.isEmpty()) {
                result.add(secondList.get(0));
                secondList.remove(0);
            }
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