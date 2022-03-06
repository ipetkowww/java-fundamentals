package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E03_LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new LinkedHashMap<>();
        int requiredCountOfKeyMaterial = 250;

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            boolean isItemObtained = false;

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (isKeyMaterial(material)) {
                    Integer quantityOfMaterial = keyMaterials.get(material);
                    keyMaterials.put(material, quantityOfMaterial + quantity);
                    Integer currentQuantity = keyMaterials.get(material);

                    if (currentQuantity >= requiredCountOfKeyMaterial) {
                        String obtainedItem = getObtainedItem(material);
                        System.out.printf("%s obtained!%n", obtainedItem);
                        keyMaterials.put(material, keyMaterials.get(material) - requiredCountOfKeyMaterial);
                        isItemObtained = true;
                        break;
                    }
                } else {
                    Integer currentQuantity = junkMaterials.get(material);
                    if (currentQuantity == null) {
                        currentQuantity = 0;
                    }
                    junkMaterials.put(material, currentQuantity + quantity);
                }
            }
            if (isItemObtained) {
                break;
            }
        }
        printAllCollectedMaterials(keyMaterials);
        printAllCollectedMaterials(junkMaterials);
    }

    static boolean isKeyMaterial(String material) {
        return material.equalsIgnoreCase("shards") ||
                material.equalsIgnoreCase("fragments") ||
                material.equalsIgnoreCase("motes");
    }

    static String getObtainedItem(String material) {
        switch (material) {
            case "shards":
                return "Shadowmourne";
            case "fragments":
                return "Valanyr";
            case "motes":
                return "Dragonwrath";
        }
        return null;
    }

    static void printAllCollectedMaterials(Map<String, Integer> allMaterials) {
        allMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}