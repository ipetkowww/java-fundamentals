package exercise_tasks;

import java.util.*;

public class E09_ForceBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> forceUsers = new LinkedHashMap<>();
        String forceSide;
        String forceUser;


        while (!input.equals("Lumpawaroo")) {
            String[] inputArgs;
            if (input.contains(" | ")) {
                inputArgs = input.split(" \\| ");
                forceSide = inputArgs[0];
                forceUser = inputArgs[1];

                List<String> users = forceUsers.get(forceSide);
                if (users == null) {
                    users = new ArrayList<>();
                    forceUsers.put(forceSide, users);
                }
                boolean isUserExist = isUserExist(forceUsers, forceUser);
                if (!isUserExist) {
                    users.add(forceUser);
                    forceUsers.put(forceSide, users);
                }
            } else {
                inputArgs = input.split(" -> ");
                forceUser = inputArgs[0]; //username
                forceSide = inputArgs[1];

                boolean isUserExist = false;
                String existedForceSide = "";

                for (Map.Entry<String, List<String>> entry : forceUsers.entrySet()) {
                    for (String user : entry.getValue()) {
                        if (user.equals(forceUser)) {
                            isUserExist = true;
                            existedForceSide = entry.getKey();
                            break;
                        }
                    }
                    if (isUserExist) {
                        break;
                    }
                }
                if (isUserExist) {
                    forceUsers.get(existedForceSide).remove(forceUser);
                }
                List<String> users = forceUsers.get(forceSide);
                if (users == null) {
                    users = new ArrayList<>();
                    forceUsers.put(forceSide, users);
                }
                users.add(forceUser);
                forceUsers.put(forceSide, users);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }
        forceUsers.entrySet().stream()
                .filter(e -> e.getValue().size() > 0)
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().forEach(v -> System.out.printf("! %s%n", v));
                });
    }

    static boolean isUserExist(Map<String, List<String>> map, String user) {
        boolean isExist = false;

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String currentUser : entry.getValue()) {
                if (currentUser.equals(user)) {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

}