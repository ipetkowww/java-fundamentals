package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_HouseParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < linesOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String guestName = command[0];

            if (command.length == 3) {
                if (!isGuestInTheList(guests, guestName)) {
                    addGuest(guests, guestName);
                } else {
                    System.out.printf("%s is already in the list!%n", guestName);
                }
            } else {
                if (isGuestInTheList(guests, guestName)) {
                    removeGuest(guests, guestName);
                } else {
                    System.out.printf("%s is not in the list!%n", guestName);
                }
            }
        }
        printListElements(guests);
    }

    static void printListElements(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

    static void removeGuest(List<String> list, String guestName) {
        list.remove(guestName);
    }

    static void addGuest(List<String> list, String guestName) {
        list.add(guestName);
    }

    static boolean isGuestInTheList(List<String> list, String guestName) {
        return list.contains(guestName);
    }
}