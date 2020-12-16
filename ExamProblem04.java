package ExamPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExamProblem04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> primaryDeck = getCards(scanner);
        List<String>  newDeck= new ArrayList<>();

        String deckChanging= scanner.nextLine();
        while (!"Ready".equals(deckChanging)){
            String[] tokens = deckChanging.split("\\s+");
            String command = tokens[0];
            String card = tokens[1];
            switch (command){
                case"Add":
                    if (primaryDeck.contains(card)) {
                        newDeck.add(card);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case"Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if ((index >= 0 && index < newDeck.size()) && primaryDeck.contains(card)){
                        newDeck.add(index,card);
                    }else{
                        System.out.println("Error!");
                    }

                    break;
                case "Remove":
                    if (newDeck.contains(card)){
                        newDeck.remove(card);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case"Swap":
                    card = tokens[1];
                    String cardTwo = tokens[2];
                    int indexOne = newDeck.indexOf(card);
                    int indexTwo = newDeck.indexOf(card);
                    newDeck.set(indexOne, cardTwo);
                    newDeck.set(indexTwo, card);
                    break;
                case"Shuffle deck":
                    Collections.reverse(newDeck);
                    break;
            }
            deckChanging=scanner.nextLine();
        }
        for (String currElement : newDeck) {
            System.out.print(currElement+" ");

        }

    }

    private static List<String> getCards(Scanner scanner) {
   String [] input = scanner.nextLine().split(":+");
   List<String> arrayList = new ArrayList<>();
        for (String currElement : input) {
            arrayList.add(currElement);

        }
        return arrayList;
    }
}
