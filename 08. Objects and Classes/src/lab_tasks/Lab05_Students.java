package lab_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab05_Students {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();

        while (!input.equals("end")) {
            String[] studentInfo = input.split("\\s+");
            Student student = Student.parse(studentInfo);
            if (isStudentExist(students, student)) {
                student.setAge(Integer.parseInt(studentInfo[2]));
                student.setHometown(studentInfo[3]);
            }
            students.add(student);
            input = scanner.nextLine();
        }
        String cityName = scanner.nextLine();
        printStudentsFrom(cityName, students);
    }

    static void printStudentsFrom(String town, List<Student> students) {
        for (Student student : students) {
            if (student.getHometown().equals(town)) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge());
            }
        }
    }

    static boolean isStudentExist(List<Student> students, Student student) {
        for (Student s : students) {
            if (s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())) {
                return true;
            }
        }
        return false;
    }

    static class Student {
        private final String firstName;
        private final String lastName;
        private int age;
        private String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public static Student parse(String[] array) {
            String firstName = array[0];
            String lastName = array[1];
            int age = Integer.parseInt(array[2]);
            String hometown = array[3];
            return new Student(firstName, lastName, age, hometown);
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getHometown() {
            return hometown;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }
    }
}
