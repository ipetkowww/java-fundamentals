package lab_tasks;

import java.util.Scanner;

public class Lab02_Grades {

    public static void main(String[] args) {
        printGradeWithWord(new Scanner(System.in).nextDouble());
    }

    static void printGradeWithWord(double grade) {
        if (grade >= 2 && grade < 3) {
            System.out.println("Fail");
        } else if (grade < 3.50) {
            System.out.println("Poor");
        } else if (grade < 4.50) {
            System.out.println("Good");
        } else if (grade < 5.50) {
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }
    }
}