package exercise_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E08_AnonymousThreat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lineOfChars = getListOfStrings(scanner.nextLine().split("\\s+"));
        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];

            switch (command) {
                case "merge":
                    int startIndex = Integer.parseInt(commandArgs[1]);
                    int endIndex = Integer.parseInt(commandArgs[2]);
                    mergeMyLine(lineOfChars, startIndex, endIndex);
                    break;
                case "divide":
                    int indexDivide = Integer.parseInt(commandArgs[1]);
                    int divideTimes = Integer.parseInt(commandArgs[2]);

                    List<String> dividedString = new ArrayList<>();
                    String currentElement = lineOfChars.get(indexDivide);
                    int substringsLength = currentElement.length() / divideTimes;
                    int count = 0;
                    String separatedElement = "";
                    int counterAdded = 0;

                    for (int i = 0; i < currentElement.length(); i++) {
                        char symbol = currentElement.charAt(i);
                        separatedElement += symbol;
                        count++;
                        if (count == substringsLength && counterAdded + 1 < divideTimes) {
                            dividedString.add(separatedElement);
                            count = 0;
                            counterAdded++;
                            separatedElement = "";
                        }
                    }
                    dividedString.add(separatedElement);
                    lineOfChars.remove(indexDivide);

                    for (int i = dividedString.size() - 1; i >= 0; i--) {
                        lineOfChars.add(indexDivide, dividedString.get(i));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (String lineOfChar : lineOfChars) {
            System.out.print(lineOfChar + " ");
        }
    }


    static void mergeMyLine(List<String> list, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex > list.size() - 1) {
            endIndex = list.size() - 1;
        }
        int counter = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            String concat = list.get(counter) + list.get(counter + 1);
            list.set(counter, concat);
            list.remove(counter + 1);
        }
    }

    static List<String> getListOfStrings(String[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
