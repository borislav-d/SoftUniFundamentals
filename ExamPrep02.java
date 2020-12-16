package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class ExamPrep02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //       •	Urgent {item} - add the item at the start of the list.  If the item already exists, skip this command.
//•	Unnecessary {item} - remove the item with the given name, only if it exists in the list. Otherwise skip this command.
//•	Correct {oldItem} {newItem} – if the item with the given old name exists, change its name with the new one. If it doesn't exist, skip this command.
//•	Rearrange {item} - if the grocery exists in the list, remove it from its current position and add it at the end of the list.

        List<String> list = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!Objects.equals(commands, "Go Shopping!")) {
            String[] tokens = commands.split(" ");
            String command = tokens[0];
            String item = tokens[1];
            switch (command){
                case"Urgent":
                    if (!list.contains(item)) {
                    list.add(0,item);
                    }
                    break;
                case"Unnecessary":
                    if (!list.contains(item)){
                        list.remove(item);
                    }
                    break;
                case " Correct":
                    String newItem = tokens[2];
                    if (list.contains(item)) {
                        list.set(list.indexOf(item), newItem);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(item)){
                        list.remove(item);
                        list.add(item);
                    }
                    break;


            }

            commands = scanner.nextLine();
            System.out.println(String.join(",",list));

            }






            
        }




    }

//    private static void printList(List<Integer> list) {
//        for (Integer element : list) {
//            System.out.print(element + " ");
//
//        }
//    }
//
//    private static List<Integer> readIntList(Scanner scanner) {
//        List<Integer> list = new ArrayList<>();
//        String[] input = scanner.nextLine().split("\\s+");
//        for (String s : input) {
//            list.add(Integer.parseInt(s));
//
//
//        }
//        return list;
//
//    }
//}
