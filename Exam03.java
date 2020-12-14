import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String receivedEmail = scanner.nextLine();
        StringBuilder emailManipulation = new StringBuilder(receivedEmail);
        String commands = scanner.nextLine();
        while (!"Complete".equals(commands)) {
            switch (commands) {
                case "Make Upper":
                    String upper = emailManipulation.toString().toUpperCase();
                    System.out.println(upper);
                    break;
                case "Make Lower":
                    String lower = emailManipulation.toString().toLowerCase();
                    System.out.println(lower);
                    break;
                case "GetDomain":
                    String[] tokens = commands.split(" ");
                    int count = Integer.parseInt(tokens[1]);
                   String lastIndex= emailManipulation.substring(count);
                   System.out.println(lastIndex);
                    break;
                case "GetUsername":
                    String username1 = emailManipulation.substring(emailManipulation.indexOf("@"));
                    System.out.println(username1);
                    break;

                case "Replace":
                   String [] command = commands.split(" ");
                    String replacement = command[1];
                    emailManipulation.replace(0,emailManipulation.length(),replacement);

                    break;
                case "Encrypt":
////                    for (int i = 0; i <emailManipulation.length() ; i++) {
////                       char test= emailManipulation.charAt(i);
////                        List<Character> encrypted = new ArrayList<>();
////                        encrypted.add(test);
////                        System.out.println(encrypted);
//
//
//
//                    }
                    break;

            }
            commands = scanner.nextLine();


        }


    }
}
