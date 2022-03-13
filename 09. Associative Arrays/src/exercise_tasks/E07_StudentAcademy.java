package exercise_tasks;

import java.util.*;

public class E07_StudentAcademy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            List<Double> grades = studentGrades.get(studentName);
            if (grades == null) {
                grades = new ArrayList<>();
                studentGrades.put(studentName, grades);
            }
            grades.add(grade);
            studentGrades.put(studentName, grades);
        }

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            double average = getAverageGrade(entry.getValue());
            if (average >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), average);
            }
        }
    }

    static double getAverageGrade(List<Double> grades) {
        double average = 0;
        for (Double grade : grades) {
            average += grade;
        }
        return average / grades.size();
    }
}