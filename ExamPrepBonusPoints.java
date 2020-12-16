package ExamPrep;
import java.util.Scanner;
public class ExamPrepBonusPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int maxAttendances = 0;
        for (int i = 0; i < studentsCount; i++) {
            int attendancesPerStudent = Integer.parseInt(scanner.nextLine());
            double totalBonus = attendancesPerStudent * 1.0 / lecturesCount * (5 + initialBonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxAttendances = attendancesPerStudent;

            }


        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendances);


    }

}