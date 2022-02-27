package exercise_tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E05_Students {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            double grade = Double.parseDouble(studentInfo[2]);
            students.add(new Student(firstName, lastName, grade));
        }
        students.sort(Comparator.comparing(Student::getGrade).reversed());
        for (Student student : students) {
            System.out.println(student);
        }

    }

    static class Student {
        private final String firstName;
        private final String lastName;
        private final double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", firstName, lastName, grade);
        }
    }
}
