package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ExamProblem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = readIntList(scanner);

        String input = scanner.nextLine();
        while(!"Mort".equals(input)){
            String [] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Add":
                    int value = Integer.parseInt(tokens[1]);
                    list.add(value);
                    break;
                case "Remove":
                    value=Integer.parseInt(tokens[1]);
                    list.remove(Integer.valueOf(value));
                    break;
                case "Replace":
                    value = Integer.parseInt(tokens[1]);
                    int replacement = Integer.parseInt(tokens[2]);
                    list.set(list.indexOf(value), replacement);
                    break;
                case "Collapse":
                   value= Integer.parseInt(tokens[1]);
                   list.removeIf(i->i<value);

                    break;

            }
            input=scanner.nextLine();
        }
        printList(list);
    }

    private static void printList(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");

        }
    }
    private static List<Integer> readIntList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String s : input) {
            list.add(Integer.parseInt(s));


        }
        return list;

    }
}