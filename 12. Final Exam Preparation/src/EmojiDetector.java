import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        BigInteger coolThreshold = BigInteger.ONE;

        while (matcher.find()) {
            int digit = Integer.parseInt(matcher.group());
            coolThreshold = coolThreshold.multiply(BigInteger.valueOf(digit));
        }

        pattern = Pattern.compile("([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        matcher = pattern.matcher(input);
        List<String> coolEmojis = new ArrayList<>();
        int foundEmojis = 0;

        while (matcher.find()) {
            foundEmojis++;
            String emoji = matcher.group("emoji");
            int sum = 0;
            for (int i = 0; i < emoji.length(); i++) {
                sum += emoji.charAt(i);
            }
            if (BigInteger.valueOf(sum).compareTo(coolThreshold) > 0) {
                coolEmojis.add(matcher.group());
            }
        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", foundEmojis);
        coolEmojis.forEach(System.out::println);
     }
}
