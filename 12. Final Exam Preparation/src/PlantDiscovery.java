import java.util.*;

public class PlantDiscovery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, Plant> plants = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] info = scanner.nextLine().split("<->");
            String plantName = info[0];
            int rarity = Integer.parseInt(info[1]);

            Plant plant = plants.get(plantName);
            if (plant == null) {
                plants.put(plantName, new Plant(plantName, rarity));
            } else {
                plant.setRarity(rarity);
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String command = input.split(": ")[0];
            String[] split = input.split(": ")[1].split(" - ");
            String plantName = split[0];

            if (!plants.containsKey(plantName)) {
                System.out.println("error");
            } else {
                switch (command) {
                    case "Rate":
                        double rating = Double.parseDouble(split[1]);
                        plants.get(plantName).addRating(rating);
                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(split[1]);
                        plants.get(plantName).setRarity(newRarity);
                        break;
                    case "Reset":
                        plants.get(plantName).resetRating();
                        break;
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plants.forEach((key, value) -> {
            double averageRating = value.getRating().stream().mapToDouble(e -> e).average().orElse(0);
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", key, value.getRarity(), averageRating);
        });

    }

    static class Plant {
        String name;
        int rarity;
        List<Double> rating;

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            rating = new ArrayList<>();
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public int getRarity() {
            return rarity;
        }

        public void addRating(double rating) {
            this.rating.add(rating);
        }

        public void resetRating() {
            this.rating = new ArrayList<>();
        }

        public List<Double> getRating() {
            return rating;
        }
    }
}
