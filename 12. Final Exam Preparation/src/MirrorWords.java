import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "([#@])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> mirrorWords = new ArrayList<>();
        int pairsCount = 0;

        while (matcher.find()) {
            pairsCount++;
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            String secondWordReversed = new StringBuilder(secondWord).reverse().toString();

            if (firstWord.equals(secondWordReversed)) {
                mirrorWords.add(firstWord);
                mirrorWords.add(secondWord);
            }

        }

        if (pairsCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", pairsCount);
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < mirrorWords.size(); i++) {
                System.out.printf("%s <=> %s", mirrorWords.get(i), mirrorWords.get(i + 1));
                i++;
                if (i < mirrorWords.size() - 1) {
                    System.out.print(", ");
                }

            }
        }
    }
}
