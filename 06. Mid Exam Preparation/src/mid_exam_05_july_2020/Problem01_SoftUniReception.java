package mid_exam_05_july_2020;

import java.util.Scanner;

public class Problem01_SoftUniReception {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int neededTime = 0;
        int totalEfficiency = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency; // 6

        while (studentsCount > 0) {
            studentsCount -= totalEfficiency;
            neededTime++;

            if (neededTime % 4 == 0) {
                neededTime++;
            }
        }
        System.out.printf("Time needed: %dh.", neededTime);
    }
}