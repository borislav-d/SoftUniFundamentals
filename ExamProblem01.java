package ExamPrep;

import java.util.Scanner;

public class ExamProblem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());
        double totalPlunder  = every3Day(days, dailyPlunder);
        if (totalPlunder>= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        }else{
            double percentage = (totalPlunder/expectedPlunder)*100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentage);
        }

    }
    private static double every3Day (int days, int dailyPlunder){
        double totalPlunder = 0;
        double thirdDayPlunder = 0;
        double fifthDayPlunder = 0;
        for (int i = 1; i <= days; i++) {
            if (i % 3 == 0) {
                thirdDayPlunder = dailyPlunder + (dailyPlunder * 0.5);
                totalPlunder += thirdDayPlunder;
            } else if (i % 5 == 0) {
                totalPlunder+= dailyPlunder;
                fifthDayPlunder = totalPlunder * 0.7;
                totalPlunder = fifthDayPlunder;
            } else {
                totalPlunder += dailyPlunder;
            }
        }
        return totalPlunder;
    }
}