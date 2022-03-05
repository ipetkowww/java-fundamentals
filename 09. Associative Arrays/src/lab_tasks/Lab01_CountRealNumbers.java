package lab_tasks;

import java.text.DecimalFormat;
import java.util.*;

public class Lab01_CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> numbersOccurrences = new TreeMap<>();


        for (double number : numbers) {
            Integer occurrence = numbersOccurrences.get(number);
            if (occurrence == null) {
                occurrence = 0;
            }
            numbersOccurrences.put(number, occurrence + 1);
        }

        DecimalFormat df = new DecimalFormat("#.#####");
        for (Map.Entry<Double, Integer> entry : numbersOccurrences.entrySet()) {
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}