import java.util.Scanner;

public class ActivationKeys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder key = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] arguments = input.split(">>>");
            String command = arguments[0];
            switch (command) {
                case "Contains":
                    contains(key, arguments[1]);
                    break;
                case "Flip":
                    flip(key, arguments[1], Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]));
                    break;
                case "Slice":
                    slice(key, Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]));
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + key);
    }

    private static void slice(StringBuilder key, int startIndex, int endIndex) {
        key.delete(startIndex, endIndex);
        System.out.println(key);
    }

    private static void flip(StringBuilder key, String command, int startIndex, int endIndex) {
        String substring = key.substring(startIndex, endIndex);
        String textForReplace = command.equals("Upper") ? substring.toUpperCase() : substring.toLowerCase();
        String replaced = key.toString().replace(substring, textForReplace);
        key.setLength(0);
        key.append(replaced);
        System.out.println(key);
    }

    private static void contains(StringBuilder key, String subStr) {
        if (key.indexOf(subStr) != -1) {
            System.out.printf("%s contains %s%n", key, subStr);
        } else {
            System.out.println("Substring not found!");
        }
    }
}
