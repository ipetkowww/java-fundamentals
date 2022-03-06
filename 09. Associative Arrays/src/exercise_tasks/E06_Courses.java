package exercise_tasks;

import java.util.*;

public class E06_Courses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] courseInfo = input.split(" : ");
            String courseName = courseInfo[0];
            String studentName = courseInfo[1];

            List<String> students = courses.computeIfAbsent(courseName, k -> new ArrayList<>());
            students.add(studentName);
            courses.put(courseName, students);
            input = scanner.nextLine();
        }

        courses.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, value.size());
            value.forEach(s -> System.out.printf("-- %s%n", s));
        });
    }
}