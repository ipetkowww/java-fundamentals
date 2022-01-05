package lab_tasks;

import java.util.Scanner;

public class Lab03_PassedOrFailed {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());

        String result = grade >= 3.00 ? "Passed!" : "Failed!";
        System.out.println(result);
    }
}
