package exercise_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E10_SoftUniCoursePlanning {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> courses = getListOfString(scanner.nextLine().split(", "));
        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] commandArgs = input.split(":");
            String command = commandArgs[0];
            String lessonTitle = commandArgs[1];

            switch (command) {
                case "Add":
                    if (!isLessonExist(lessonTitle, courses)) {
                        courses.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    if (!isLessonExist(lessonTitle, courses)) {
                        int index = Integer.parseInt(commandArgs[2]);
                        courses.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    courses.remove(lessonTitle);
                    String exercise = lessonTitle + "-Exercise";
                    courses.remove(exercise);
                    break;
                case "Swap":
                    String exOne = lessonTitle + "-Exercise";
                    String exTwo = commandArgs[2] + "-Exercise";

                    if (isLessonExist(lessonTitle, courses) && isLessonExist(commandArgs[2], courses)) {
                        int firstIndex = courses.indexOf(lessonTitle);
                        String secondElement = commandArgs[2];
                        int secondIndex = courses.indexOf(secondElement);
                        courses.set(firstIndex, secondElement);
                        courses.set(secondIndex, lessonTitle);
                        if (courses.contains(exOne)) {
                            courses.remove(exOne);
                            courses.add(courses.indexOf(lessonTitle) + 1, exOne);
                        }
                        if (courses.contains(exTwo)) {
                            courses.remove(exTwo);
                            courses.add(courses.indexOf(commandArgs[2]) + 1, exTwo);
                        }
                    }
                    break;
                case "Exercise":
                    String ex1 = lessonTitle + "-Exercise";
                    if (!isLessonExist(lessonTitle, courses)) {
                        courses.add(lessonTitle);
                        courses.add(ex1);
                    } else if (courses.contains(lessonTitle) && !courses.contains(ex1)) {
                        int index = courses.indexOf(commandArgs[1]);
                        courses.add(index + 1, ex1);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printCourses(courses);
    }

    static void printCourses(List<String> courses) {
        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, courses.get(i));
        }
    }

    static boolean isLessonExist(String lesson, List<String> courses) {
        return courses.contains(lesson);
    }

    static List<String> getListOfString(String[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}