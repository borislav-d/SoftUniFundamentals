package ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExamPrepInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!"Craft!".equals(input)) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String item = tokens[1];

            switch (command) {
                case "Collect":
                    if (!inventory.contains(item)) {
                        inventory.add(item);
                    }
                    break;
                case "Drop":
                    if (inventory.contains(item)) {
                        inventory.remove(item);
                    }
                    break;
                case "Combine Items":
                    String[] combined = item.split(":");
                    String oldItem = combined[0];
                    String newItem = combined[1];
                    if (inventory.contains(oldItem)) {
                        int index = inventory.indexOf(oldItem);
                        inventory.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (inventory.contains(item)) {
                        inventory.add(item);

                    }
                    break;

            }

            input = scanner.next();
            System.out.println(String.join(", ", inventory));
        }

    }
}
