import java.util.*;

public class Prep04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encrypted = scanner.nextLine();
        String commands = scanner.nextLine();

        while (!"Finish".equals(commands)) {
            String[] tokens = commands.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Replace":
                    encrypted = replace(encrypted, tokens[1].charAt(0), tokens[2].charAt(0));
                    break;
                case "Cut":
                    int indexOf = Integer.parseInt(tokens[1]);
                    int toIndex = Integer.parseInt(tokens[2]);
                    encrypted = cut(encrypted, indexOf, toIndex);

                    break;
                case "Make":
                    encrypted = make(encrypted, tokens[1]);
                    break;
                case "Check":
                    check(encrypted, tokens[1]);
                    break;
                case "Sum":
                    int beginSumIndex = Integer.parseInt(tokens[1]);
                    int endSumIndex = Integer.parseInt(tokens[2]);
                    sum(encrypted, beginSumIndex, endSumIndex);
                    break;


            }
        }
    }

    private static void sum(String encrypted, int beginSumIndex, int endSumIndex) {
        if (areValidIndexes(encrypted.length(), beginSumIndex, endSumIndex)) {
            int sum = 0;
            for (int i = beginSumIndex; i <= endSumIndex; i++) {
                sum += encrypted.charAt(i);

            }
            System.out.println(sum);
        }
    }

    private static void check(String encrypted, String token) {
        if (encrypted.contains(token)) {
            System.out.println("Message contains" + token);
        } else {
            System.out.println("Message doesn't contain" + token);

        }
    }

    private static String make(String encrypted, String token) {
        if (token.equals("Upper")) {
            encrypted = encrypted.toUpperCase();
        } else {
            encrypted = encrypted.toLowerCase();

        }
        System.out.println(encrypted);
        return encrypted;
    }

    public static String replace(String encrypted, char searchFor, char replaceWith) {
        encrypted = encrypted.replace(searchFor, replaceWith);
        System.out.println(encrypted);
        return encrypted;
    }

    public static String cut(String encrypted, int startIndex, int endIndex) {
        int length = encrypted.length();
        if (!areValidIndexes(length, startIndex, endIndex)) {
            String firstPart = encrypted.substring(0, startIndex);
            String secondPart = encrypted.substring(endIndex + 1, length);
            System.out.println(firstPart + secondPart);
        }
        return encrypted;

    }

    public static boolean areValidIndexes(int length, int startIndex, int endIndex) {
        if (startIndex >= 0 && startIndex < length && endIndex >= 0 && endIndex < length) {
            return true;
        } else {
            System.out.println("Invalid indexes");
            return false;
        }
    }
}
