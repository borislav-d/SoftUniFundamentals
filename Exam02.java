import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String registration = scanner.nextLine();
        Pattern pattern = Pattern.compile("(U\\$)[A-Z][a-z]{2,}\\1+(P@\\$)[A-Za-z]{5,}\\d*\\2");
        Matcher matcher = pattern.matcher(registration);
        int loginCount = 0;
        for (int i = 0; i < n; i++) {
            if (matcher.find()) {
                String username = matcher.group(0);
                String password = matcher.group(1);
                System.out.println("Registration was successful");
                System.out.printf(String.join("") + "Username: %s, Password: %s%n", username, password);
                loginCount++;
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.println("Successful registrations: " + loginCount);


    }
}
