import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WildZoo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Animal> animals = new LinkedHashMap<>();
        Map<String, Integer> areas = new LinkedHashMap<>();

        while (!input.equals("EndDay")) {
            String[] arguments = input.split(": ");
            String command = arguments[0];
            String[] info = arguments[1].split("-");
            String animalName = info[0];

            switch (command) {
                case "Add":
                    int neededFoodQuantity = Integer.parseInt(info[1]);
                    String area = info[2];
                    Animal animal = animals.get(animalName);
                    if (animal == null) {
                        animals.put(animalName, new Animal(animalName, neededFoodQuantity, area));
                        Integer currentArea = areas.get(area);
                        if (currentArea == null) {
                            currentArea = 0;
                            areas.put(area, currentArea);
                        }
                        areas.put(area, currentArea + 1);
                    } else {
                        animal.setNeededFood(animal.getNeededFood() + neededFoodQuantity);
                    }
                    break;
                case "Feed":
                    Animal feedAnimal = animals.get(animalName);
                    int food = Integer.parseInt(info[1]);
                    if (feedAnimal != null) {
                        feedAnimal.setNeededFood(feedAnimal.getNeededFood() - food);
                        if (feedAnimal.getNeededFood() <= 0) {
                            String currentArea = feedAnimal.getArea();
                            animals.remove(animalName);
                            areas.put(currentArea, areas.get(currentArea) - 1);
                            System.out.printf("%s was successfully fed%n", animalName);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Animals:");
        animals.forEach((key, value) -> System.out.printf(" %s -> %dg%n", key, value.getNeededFood()));
        System.out.println("Areas with hungry animals:");
        areas.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf(" %s: %d%n", e.getKey(), e.getValue()));
    }

    static class Animal {
        private String name;
        private int neededFood;
        String area;

        public Animal(String name, int neededFood, String area) {
            this.name = name;
            this.neededFood = neededFood;
            this.area = area;
        }

        public void setNeededFood(int neededFood) {
            this.neededFood = neededFood;
        }

        public int getNeededFood() {
            return neededFood;
        }

        public String getArea() {
            return area;
        }
    }
}
