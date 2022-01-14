package lab_tasks;

import java.util.Scanner;

public class Lab01_DayOfWeek {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayAsNumber = scanner.nextInt();

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (dayAsNumber < 1 || dayAsNumber > 7) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(days[dayAsNumber - 1]);
        }
    }
}