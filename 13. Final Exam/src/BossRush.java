import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("\\|(?<boss>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+\\s[A-Za-z]+)#");

        for (int i = 0; i < lines; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String bossName = matcher.group("boss");
                String title = matcher.group("title");
                System.out.printf("%s, The %s%n", bossName, title);
                System.out.printf(">> Strength: %d%n", bossName.length());
                System.out.printf(">> Armor: %s%n", title.length());
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
