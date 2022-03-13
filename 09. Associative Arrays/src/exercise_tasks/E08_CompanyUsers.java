package exercise_tasks;

import java.util.*;

public class E08_CompanyUsers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> companyEmployees = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] companyInfo = input.split(" -> ");
            String companyName = companyInfo[0];
            String employeeId = companyInfo[1];

            List<String> employeeIds = companyEmployees.get(companyName);
            if (employeeIds == null) {
                employeeIds = new ArrayList<>();
                companyEmployees.put(companyName, employeeIds);
            }
            if (!employeeIds.contains(employeeId)) {
                employeeIds.add(employeeId);
                companyEmployees.put(companyName, employeeIds);
            }
            input = scanner.nextLine();
        }
        companyEmployees.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(v -> System.out.printf("-- %s%n", v));
        });
    }
}