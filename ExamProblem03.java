package ExamPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class ExamProblem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cards = scanner.nextLine().split(":");
        List<String> newDeck = new ArrayList<>(Arrays.asList(cards));

        String input = scanner.nextLine();
        while(!"Ready".equals(input)){
            String [] tokens = input.split(" ");
            switch (input){
                case "Add":
                    String card = tokens[1];
                    if (newDeck.contains(card)) {
                        newDeck.add(card);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    card = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (newDeck.contains(card)){
                        newDeck.set(index,card);
                    }else{
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    card=tokens[1];
                    if (newDeck.contains(card)){
                        newDeck.remove(card);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    card = tokens[1];
                    String cardTwo = tokens[2];
                    int indexOne = newDeck.indexOf(card);
                    int indexTwo = newDeck.indexOf(card);
                    newDeck.set(indexOne, cardTwo);
                    newDeck.set(indexTwo, card);
                    break;
                case "Shuffle deck":
                    Collections.reverse(newDeck);
                    break;

            }
       input=scanner.nextLine();
        }
        System.out.println(String.join(" ",newDeck));
    }
}
