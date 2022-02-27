package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06_VehicleCatalogue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!input.equals("End")) {
            String[] vehicleInfo = input.split("\\s+");
            vehicles.add(new Vehicle(vehicleInfo[0], vehicleInfo[1], vehicleInfo[2], Integer.parseInt(vehicleInfo[3])));
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {
            String model = input;
            vehicles.stream()
                    .filter(e -> e.getModel().equals(model))
                    .forEach(System.out::println);
            input = scanner.nextLine();
        }
        double truck = getAverage(vehicles, "truck");
        System.out.printf("Cars have average horsepower of: %.2f.%n", getAverage(vehicles, "car"));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", getAverage(vehicles, "truck"));
    }

    private static double getAverage(List<Vehicle> vehicles, String type) {
        double sum = vehicles.stream().filter(e -> e.getType().equals(type)).map(Vehicle::getHorsepower).mapToDouble(Integer::doubleValue).sum();
        long count = vehicles.stream().filter(e -> e.getType().equals(type)).count();
        return count == 0 ? 0 : sum / count;
    }

    static class Vehicle {
        private final String type;
        private final String model;
        private final String color;
        private final int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getModel() {
            return model;
        }

        public String getType() {
            return type;
        }

        public int getHorsepower() {
            return horsepower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%n" +
                    "Model: %s%n" +
                    "Color: %s%n" +
                    "Horsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1),
                    this.model, this.color, this.horsepower);
        }
    }
}
