package exercise_tasks;

import java.util.Scanner;

public class E10_PadawanEquipment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyAmount = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        int beltsCount = studentsCount - (studentsCount / 6);
        int lightsabersCount = studentsCount + (int) Math.ceil((studentsCount * 0.1));

        double moneyNeeded = lightsabersPrice * lightsabersCount +
                robePrice * studentsCount +
                beltsPrice * beltsCount;

        double difference = Math.abs(moneyAmount - moneyNeeded);

        if (moneyAmount >= moneyNeeded) {
            System.out.printf("The money is enough - it would cost %.2flv.", moneyNeeded);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", difference);
        }
    }
}