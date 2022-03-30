import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, City> cities = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] arguments = input.split("\\|\\|");
            String cityName = arguments[0];
            int population = Integer.parseInt(arguments[1]);
            int gold = Integer.parseInt(arguments[2]);
            City city = cities.get(cityName);
            if (city == null) {
                cities.put(cityName, new City(cityName, population, gold));
            } else {
                city.setGold(city.getGold() + gold);
                city.setPopulation(city.getPopulation() + population);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] arguments = input.split("=>");
            String command = arguments[0];
            switch (command) {
                case "Plunder":
                    handlePlunder(cities, arguments[1], Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]));
                    break;
                case "Prosper":
                    handleProsper(cities, arguments[1], Integer.parseInt(arguments[2]));
                    break;
            }
            input = scanner.nextLine();
        }

        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %s wealthy settlements to go to:%n", cities.size());
            cities.forEach((key, value) ->
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key, value.getPopulation(), value.getGold()));
        }
    }

    private static void handleProsper(Map<String, City> cities, String town, int gold) {
        City city = cities.get(town);
        if (gold < 0) {
            System.out.println("Gold added cannot be a negative number!");
        } else {
            city.setGold(city.getGold() + gold);
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, city.getGold());
        }
    }

    private static void handlePlunder(Map<String, City> cities, String town, int people, int gold) {
        City city = cities.get(town);
        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
        city.setPopulation(city.getPopulation() - people);
        city.setGold(city.getGold() - gold);
        if (city.getGold() <= 0 || city.getPopulation() <= 0) {
            cities.remove(town);
            System.out.printf("%s has been wiped off the map!%n", town);
        }
    }

    static class City {

        private String name;
        private int population;
        private int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }
}
