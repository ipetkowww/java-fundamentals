import java.util.Scanner;

public class WorldTour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stops = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] arguments = input.split(":");
            String command = arguments[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(arguments[1]);
                    String stop = arguments[2];
                    addStop(stops, index, stop);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(arguments[1]);
                    int endIndex = Integer.parseInt(arguments[2]);
                    if ((startIndex >= 0) && (startIndex < endIndex) && (endIndex < stops.length())) {
                        removeStop(stops, startIndex, endIndex);
                    }
                    break;
                case "Switch":
                    switchStops(stops, arguments[1], arguments[2]);
                    break;
            }
            System.out.println(stops);
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    private static void switchStops(StringBuilder stops, String oldStop, String newStop) {
        String replace = stops.toString().replace(oldStop, newStop);
        stops.setLength(0);
        stops.append(replace);
    }

    private static void removeStop(StringBuilder stops, int startIndex, int endIndex) {
        if (isValidIndex(stops, startIndex) && isValidIndex(stops, endIndex)) {
            stops.replace(startIndex, endIndex + 1, "");
        }
    }

    private static void addStop(StringBuilder stops, int index, String stop) {
        if (isValidIndex(stops, index)) {
            stops.insert(index, stop);
        }
    }

    static boolean isValidIndex(StringBuilder text, int index) {
        return index >= 0 && index < text.length();
    }
}
