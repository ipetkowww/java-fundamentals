package exercise_tasks;

import java.util.Scanner;

public class E02_CommonElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArray = scanner.nextLine().split("\\s+");
        String[] secondArray = scanner.nextLine().split("\\s+");

        for (String secondArrElement : secondArray) {
            for (String firstArrElement : firstArray) {
                if (secondArrElement.equals(firstArrElement)) {
                    System.out.printf("%s ", secondArrElement);
                }
            }
        }
    }
}