package mid_exam_05_no_date;

import java.util.Scanner;

public class Problem01_BonusScoringSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0;
        int maxAttendace = 0;

        for (int i = 0; i < students; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = attendance * 1.0 / lectures * (5 + bonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxAttendace = attendance;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendace);
    }
}