package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05_BombNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfIntegers(scanner.nextLine().split("\\s+"));
        List<Integer> specialNumbers = getListOfIntegers(scanner.nextLine().split("\\s+"));
        int bombNumber = specialNumbers.get(0);
        int power = specialNumbers.get(1);

        while (numbers.contains(bombNumber)) {
            int index = numbers.indexOf(bombNumber);

            int left = Math.max(0, index - power);
            int right = Math.min(numbers.size() - 1, index + power);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }
        System.out.println(getSumOfElements(numbers));
    }

    static int getSumOfElements(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            sum += element;
        }
        return sum;
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}