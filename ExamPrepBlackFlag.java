package ExamPrep;

import java.util.Scanner;

public class ExamPrepBlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysToPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double plunderToThisMoment = 0;
        for (int i = 1; i <= daysToPlunder; i++) {
            plunderToThisMoment += dailyPlunder;
            if (i % 3 == 0) { // every 3rd day they gain 50% of the dailyPlunder
                plunderToThisMoment += 0.5 * dailyPlunder;

            }
            if (i % 5 == 0) {// every 5th day they lose 30% of the whole plunder
                //30% of the whole plunder not the daily one
                plunderToThisMoment = plunderToThisMoment - 0.3 * plunderToThisMoment;
                // or plunderToThisMoment = 0.7 * plunderToThisMoment
            }
        }
        if (plunderToThisMoment >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", plunderToThisMoment);
        } else {
           double percentOfTotalPlunder = (plunderToThisMoment/ expectedPlunder)*100;

            System.out.printf("Collected only %.2f%% of the plunder.", percentOfTotalPlunder);
        }


    }
}
