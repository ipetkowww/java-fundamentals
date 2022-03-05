package lab_tasks;

import java.util.*;

public class Lab02_WordSynonyms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> wordSynonyms = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            List<String> synonyms = wordSynonyms.get(word);
            if (synonyms == null) {
                synonyms = new ArrayList<>();
                wordSynonyms.put(word, synonyms);
            }
            synonyms.add(synonym);
            wordSynonyms.put(word, synonyms);
        }

        for (Map.Entry<String, List<String>> entry : wordSynonyms.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}