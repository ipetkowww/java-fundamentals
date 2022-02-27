package exercise_tasks;

import java.util.*;

public class E03_OpinionPoll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = Person.parse(personInfo);
            if (person.getAge() > 30) {
                people.add(person);
            }
        }
        people.sort(Comparator.comparing(Person::getName));

        for (Person person : people) {
            System.out.println(person);
        }
    }

    static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static Person parse(String[] personInfo) {
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            return new Person(name, age);
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", name, age);
        }
    }
}
