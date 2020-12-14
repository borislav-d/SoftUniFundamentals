import java.util.Scanner;

public class Prep01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder allStops = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt(tokens[1]);
                    String insertString = tokens[2];
                    if (isValidIndex(allStops, insertIndex)) {
                        allStops.insert(insertIndex, insertString);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(allStops, startIndex) && isValidIndex(allStops, endIndex - 1)) {
                        allStops.replace(startIndex, endIndex, "");
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    allStops = new StringBuilder(allStops.toString().replace(oldString, newString));

                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
            System.out.println(allStops);
            command = scanner.nextLine();

        }
        System.out.println("Ready for world tour! Planned stops: " + allStops);

    }

    static boolean isValidIndex(StringBuilder s, int index) {
        return index >= 0 && index < s.length();

    }
}
