package ExamPrep;

import java.util.Scanner;

public class ExamPrepMuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rooms = scanner.nextLine().split("\\|");

        int initialHealth = 100;
        int initialBitcoins = 0;

        for (String room : rooms) {
            String[] currentRoom = room.split("\\s+");
            String command = currentRoom[0];
            int number = Integer.parseInt(currentRoom[1]);

            if ("potion".equals(command)) {
                if (initialHealth + number > 100) {
                    number = 100 - initialHealth;
                }
                initialHealth += number;

                System.out.printf("You healed for %d hp.%n", number);
                System.out.printf("Current health: %d hp.%n", initialHealth);


            } else if ("chest".equals(command)) {
                initialBitcoins = number;
                System.out.printf("You found %d bitcoins.%n", initialBitcoins);


            } else {

                if (initialHealth - number<=0){
                    System.out.printf("You died! Killed by %s.%n",command);
                    System.out.printf("Best room:%s.%n",room +1);
                    return;

                }else{
                    initialHealth-= number;
                    System.out.printf("You slayed %s.%n",command);

                }
            }


        }
        System.out.printf("You've made it! Bitcoins: %d, Health: %d.", initialBitcoins, initialHealth);


    }
}
