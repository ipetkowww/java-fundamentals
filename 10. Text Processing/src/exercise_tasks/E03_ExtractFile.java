package exercise_tasks;

import java.util.Scanner;

public class E03_ExtractFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        int indexOfSlash = path.lastIndexOf("\\");
        String[] fileAndExtension = path.substring(indexOfSlash + 1).split("\\.");

        System.out.printf("File name: %s%n", fileAndExtension[0]);
        System.out.printf("File extension: %s", fileAndExtension[1]);
    }
}
