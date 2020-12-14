import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prep02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String places = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=/])([A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(places);
        List<String> destinations = new ArrayList<>();
        while (matcher.find()){
           destinations.add(matcher.group(2));

        }
        System.out.println("Destinations: "+ String.join(", ", destinations));
        System.out.println("Travel Points: " + destinations.stream().mapToInt(l->l.length()).sum());
    }
}

