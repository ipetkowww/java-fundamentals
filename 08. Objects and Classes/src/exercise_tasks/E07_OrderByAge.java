package exercise_tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E07_OrderByAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("End")) {
            String[] personInfo = input.split("\\s+");
            String name = personInfo[0];
            String ID = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);
            people.add(new Person(name, ID, age));
            input = scanner.nextLine();
        }
        people.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
    }

    static class Person {

        private final String name;
        private final String ID;
        private final int age;

        public Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.ID, this.age);
        }
    }
}
