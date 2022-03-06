package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E10_SoftUniExamResults {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> userPoints = new LinkedHashMap<>();
        Map<String, Integer> languageSubmissions = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] examInfo = input.split("-");
            String username = examInfo[0];
            String language = examInfo[1];
            if (language.equals("banned")) {
                userPoints.remove(username);
            } else {
                int points = Integer.parseInt(examInfo[2]);
                Integer currentPoints = userPoints.get(username);
                Integer currentSubmissions = languageSubmissions.get(language);

                if (currentPoints == null) {
                    currentPoints = 0;
                }
                if (currentSubmissions == null) {
                    currentSubmissions = 0;
                }
                if (currentPoints < points) {
                    userPoints.put(username, points);
                }
                languageSubmissions.put(language, currentSubmissions + 1);
            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");
        userPoints.forEach((key, value) -> System.out.printf("%s | %d%n", key, value));
        System.out.println("Submissions:");
        languageSubmissions.forEach((key, value) -> System.out.printf("%s - %d%n", key, value));
    }
}