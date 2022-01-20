package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E09_PokemonDontGo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfIntegers(scanner.nextLine().split("\\s+"));
        int sumOfRemoved = 0;
        int removedElement;

        while (!numbers.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index <= numbers.size() - 1) {
                removedElement = numbers.get(index);
                numbers.remove(index);
            } else if (index < 0) {
                removedElement = numbers.get(0);
                numbers.set(0, numbers.get(numbers.size()-1));
            } else {
                removedElement = numbers.get(numbers.size()-1);
                numbers.set((numbers.size()-1), numbers.get(0));
            }
            sumOfRemoved += removedElement;
            for (int i = 0; i < numbers.size(); i++) {
                int currentElement = numbers.get(i);
                if (currentElement <= removedElement) {
                    numbers.set(i, currentElement + removedElement);
                } else {
                    numbers.set(i, currentElement - removedElement);
                }
            }
        }
        System.out.println(sumOfRemoved);
    }

    static List<Integer> getListOfIntegers(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }
}