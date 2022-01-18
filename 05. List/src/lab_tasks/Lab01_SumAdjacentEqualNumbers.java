package lab_tasks;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab01_SumAdjacentEqualNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = getListOfNumbers(scanner.nextLine().split("\\s+"));

        for (int i = 0; i < numbers.size() - 1; i++) {
            double currentElement = numbers.get(i);
            double nextElement = numbers.get(i + 1);

            if (currentElement == nextElement) {
                numbers.set(i, currentElement + nextElement);
                numbers.remove(i + 1);
                i = -1;
            }
        }
        printListElements(numbers);
    }

    static List<Double> getListOfNumbers(String[] array) {
        List<Double> result = new ArrayList<>();
        for (String element : array) {
            result.add(Double.parseDouble(element));
        }
        return result;
    }

    static void printListElements(List<Double> list) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Double element : list) {
            System.out.print(decimalFormat.format(element) + " ");
        }
    }
}