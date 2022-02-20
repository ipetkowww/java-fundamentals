import java.util.Scanner;

public class Problem02_TaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vehicles = scanner.nextLine().split(">>");
        double total = 0;

        for (String vehicle : vehicles) {
            String[] currentVehicle = vehicle.split("\\s+");
            String carType = currentVehicle[0];
            int years = Integer.parseInt(currentVehicle[1]);
            int kilometers = Integer.parseInt(currentVehicle[2]);
            double taxes = 0;
            boolean isValidCar = true;

            switch (carType) {
                case "family":
                    taxes = Math.floor(kilometers * 1.0 / 3000) * 12 + (50 - years * 5);
                    break;
                case "heavyDuty":
                    taxes = Math.floor(kilometers * 1.0 / 9000) * 14 + (80 - years * 8);
                    break;
                case "sports":
                    taxes = Math.floor(kilometers * 1.0 / 2000) * 18 + (100 - years * 9);
                    break;
                default:
                    isValidCar = false;
                    break;
            }
            total += taxes;

            if (isValidCar) {
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxes);
            } else {
                System.out.println("Invalid car type.");
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", total);
    }

}
