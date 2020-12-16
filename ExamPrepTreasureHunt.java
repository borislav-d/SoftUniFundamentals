package ExamPrep;

import java.util.*;

public class ExamPrepTreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String treasureChestContent = scanner.nextLine();
        String[] splitChest = treasureChestContent.split("\\|");
        List<String> chestContentList = new ArrayList<>(Arrays.asList(splitChest));


        String commands = scanner.nextLine();

        while (!"Yohoho!".equals(commands)) {
            commands = scanner.nextLine();
            String[] tokens = commands.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (!chestContentList.contains(tokens[i])) {
                            chestContentList.add(0, tokens[i]);

                        }
                    }

                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(tokens[1]);
                    if (dropIndex < 0 || dropIndex >= chestContentList.size()) {
                        break;
                    }

                    chestContentList.add(chestContentList.remove(dropIndex));//маха индекса и после го добавя отзад в листа

                    break;
                case "Steal":
                    int stealAmount = Integer.parseInt(tokens[1]);
                    List<String> stolen = new ArrayList<>();
                    String output=" ";
                    for (int i = 0; i < stealAmount; i++) {
                        int lastIndex = chestContentList.size()-1;
                        stolen.add(chestContentList.remove(lastIndex));

                    }
                    Collections.reverse(stolen);
                    output=String.join(", ",stolen);
                    System.out.println(output);
                    break;

            }

        }


    }
}
