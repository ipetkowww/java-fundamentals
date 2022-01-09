package exercise_tasks;

import java.util.Scanner;

public class E03_Elevator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        int courses = (int) Math.ceil((double) peopleCount / elevatorCapacity);
        System.out.println(courses);
    }
}