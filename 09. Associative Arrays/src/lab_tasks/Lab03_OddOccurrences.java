package lab_tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Lab03_OddOccurrences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        Map<String, Integer> wordOccurrences = new LinkedHashMap<>();

        for (String word : words) {
            Integer occurrence = wordOccurrences.get(word.toLowerCase());
            if (occurrence == null) {
                occurrence = 0;
            }
            wordOccurrences.put(word.toLowerCase(), occurrence + 1);
        }

        List<String> result = wordOccurrences.entrySet().stream()
                .filter(e -> e.getValue() % 2 == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", result));
    }
}