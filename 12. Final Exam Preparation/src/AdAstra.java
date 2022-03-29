import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "([#|])(?<item>[a-zA-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int totalCalories = 0;
        List<Item> items = new ArrayList<>();

        while (matcher.find()) {
            int calories = Integer.parseInt(matcher.group("calories"));
            String name = matcher.group("item");
            String date = matcher.group("date");
            items.add(new Item(name, date, calories));
            totalCalories += calories;
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        items.forEach(e -> System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n",
                e.getName(), e.getDate(), e.getCalories()));
    }

    static class Item {
        private final String name;
        private final String date;
        private final int calories;

        public Item(String name, String date, int calories) {
            this.name = name;
            this.date = date;
            this.calories = calories;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public int getCalories() {
            return calories;
        }
    }
}
