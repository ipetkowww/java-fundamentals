import java.util.Scanner;

public class Hogwarts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder spell = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Abracadabra")) {
            String[] arguments = input.split("\\s+");
            String command = arguments[0];

            switch (command) {
                case "Abjuration":
                    abjuration(spell);
                    break;
                case "Necromancy":
                    necromancy(spell);
                    break;
                case "Illusion":
                    illusion(spell, Integer.parseInt(arguments[1]), arguments[2]);
                    break;
                case "Divination":
                    boolean divination = divination(spell, arguments[1], arguments[2]);
                    if (divination) {
                        System.out.println(spell);
                    }
                    break;
                case "Alteration":
                    boolean alternation = alternation(spell, arguments[1]);
                    if (alternation) {
                        System.out.println(spell);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void abjuration(StringBuilder spell) {
        String uppercase = spell.toString().toUpperCase();
        spell.setLength(0);
        spell.append(uppercase);
        System.out.println(spell);
    }

    private static void necromancy(StringBuilder spell) {
        String lowercase = spell.toString().toLowerCase();
        spell.setLength(0);
        spell.append(lowercase);
        System.out.println(spell);
    }

    private static void illusion(StringBuilder spell, int index, String letter) {
        if (index >= 0 && index < spell.length()) {
            spell.replace(index, index + letter.length(), letter);
            System.out.println("Done!");
        } else {
            System.out.println("The spell was too weak.");
        }
    }

    private static boolean divination(StringBuilder spell, String firstSubstring, String secondSubstring) {
        int index = spell.indexOf(firstSubstring);
        boolean isDivination = false;
        while (index != -1) {
            spell.replace(index, index + firstSubstring.length(), secondSubstring);
            index = spell.indexOf(firstSubstring);
            isDivination = true;
        }
        return isDivination;
    }

    private static boolean alternation(StringBuilder spell, String subStr) {
        int index = spell.indexOf(subStr);
        boolean isDeleted = false;
        if (index != -1) {
            spell.delete(index ,index + subStr.length());
            isDeleted = true;
        }
        return isDeleted;
    }
}
