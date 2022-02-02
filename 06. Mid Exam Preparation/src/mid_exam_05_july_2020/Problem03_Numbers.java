package mid_exam_05_july_2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem03_Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = getListOfNumbers(scanner.nextLine().split("\\s+"));

        double average = numbers.stream().mapToInt(Integer::intValue).average().orElseThrow();
        List<Integer> greaterThanAverage = numbers.stream().filter(e -> e > average)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (greaterThanAverage.size() == 0) {
            System.out.println("No");
        } else {
            greaterThanAverage.stream().limit(5).forEach(e -> System.out.print(e + " "));
        }
    }

    static List<Integer> getListOfNumbers(String[] array) {
        List<Integer> result = new ArrayList<>();
        for (String element : array) {
            result.add(Integer.parseInt(element));
        }
        return result;
    }
}