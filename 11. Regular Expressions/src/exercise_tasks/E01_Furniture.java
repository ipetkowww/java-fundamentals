package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01_Furniture {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?:[>]{2})(?<type>[A-Z]|[a-zA-Z]+)(?:[<]{2})(?<price>[\\d]+\\.[\\d]+|[\\d]+)(?:[!]{1})(?<count>[\\d]+)");

        List<String> furniture = new ArrayList<>();
        String input = scan.nextLine();
        double sum = 0;
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String furn = matcher.group("type");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("count"));
                furniture.add(furn);
                sum += price*quantity;
            }

            input = scan.nextLine();
        }

        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);
    }
}
