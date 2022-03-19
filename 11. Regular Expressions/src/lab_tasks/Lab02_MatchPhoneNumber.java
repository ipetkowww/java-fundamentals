package lab_tasks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab02_MatchPhoneNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\+359([\\s-])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(input);

        boolean isPhoneNumberFound = matcher.find();
        while (isPhoneNumberFound) {
            System.out.printf("%s", matcher.group());
            isPhoneNumberFound = matcher.find();

            if (isPhoneNumberFound) {
                System.out.printf(", ");
            }
        }
    }
}
