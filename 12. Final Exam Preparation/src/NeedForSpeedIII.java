import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            String model = carInfo[0];
            cars.put(model, Car.parseCar(carInfo));
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] arguments = input.split(" : ");
            String command = arguments[0];
            String carBrand = arguments[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(arguments[2]);
                    int fuelDrive = Integer.parseInt(arguments[3]);
                    handleDrive(cars, carBrand, distance, fuelDrive);
                    break;
                case "Refuel":
                    int fuel = Integer.parseInt(arguments[2]);
                    handleRefuel(cars, carBrand, fuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(arguments[2]);
                    handleRevert(cars, carBrand, kilometers);
                    break;
            }
            input = scanner.nextLine();
        }
        cars.forEach((key, value)
                -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", key, value.getMileage(), value.getFuel()));
    }

    private static void handleDrive(Map<String, Car> cars, String carBrand, int distance, int fuelDrive) {
        Car car = cars.get(carBrand);
        if (car.getFuel() < fuelDrive) {
            System.out.println("Not enough fuel to make that ride");
        } else {
            car.setMileage(distance + car.getMileage());
            car.setFuel(car.getFuel() - fuelDrive);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carBrand, distance, fuelDrive);
        }

        if (car.getMileage() >= 100000) {
            cars.remove(carBrand);
            System.out.printf("Time to sell the %s!%n", carBrand);
        }
    }

    private static void handleRevert(Map<String, Car> cars, String carBrand, int kilometers) {
        Car car = cars.get(carBrand);
        car.decreaseMileage(kilometers);
        System.out.printf("%s mileage decreased by %d kilometers%n", carBrand, kilometers);
        int mileage = car.getMileage();
        if (mileage < 10_000) {
            car.setMileage(10_000);
        }
    }

    private static void handleRefuel(Map<String, Car> cars, String carBrand, int fuel) {
        if (cars.get(carBrand).getFuel() + fuel >= 75) {
            int fuelBefore = cars.get(carBrand).getFuel();
            cars.get(carBrand).setFuel(75);
            System.out.printf("%s refueled with %d liters%n", carBrand, 75 - fuelBefore);
        } else {
            cars.get(carBrand).setFuel(cars.get(carBrand).getFuel() + fuel);
            System.out.printf("%s refueled with %d liters%n", carBrand, fuel);
        }
    }

    static class Car {
        private String model;
        private int mileage;
        private int fuel;

        public Car(String model, int mileage, int fuel) {
            this.model = model;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public static Car parseCar(String[] carInfo) {
            String model = carInfo[0];
            int mileage = Integer.parseInt(carInfo[1]);
            int fuel = Integer.parseInt(carInfo[2]);
            return new Car(model, mileage, fuel);
        }

        public int getMileage() {
            return mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public void decreaseMileage(int kilometers) {
            this.mileage -= kilometers;
        }
    }
}
