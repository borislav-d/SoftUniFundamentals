import java.util.HashMap;
import java.util.Scanner;

public class Prep03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Prep0301.Plant> plants = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        //пълнене на мапа с растения
        for (int i = 0; i < n; i++) {
            String[] nameAndRarity = scanner.nextLine().split("<->");
            Prep0301.Plant p = new Prep0301.Plant(nameAndRarity[0], Integer.parseInt(nameAndRarity[1]));
            plants.put(p.getName(), p);

        }
        // четене на команди и разбиване на токени
        String command = scanner.nextLine();
        while (!"Exhibition".equals(command)) {
            String[] commandAndParameters = command.split(": ");

            switch (commandAndParameters[0]) {
                case "Rate":
                    String[] rateParameters = commandAndParameters[1].split(" - ");
                    String ratePlantName = rateParameters[0];
                    int rating = Integer.parseInt(rateParameters[1]);
                     plants.get(ratePlantName).addRating(rating);
                     // взимане на растението от мапа
                    Prep0301.Plant ratePlant = plants.get(ratePlantName);
                    if (ratePlant != null){
                        ratePlant.addRating(rating);
                    }else{
                        System.out.println("Error");
                    }

                    break;
                case "Update":
                    String[] updateParameters = commandAndParameters[1].split(" - ");
                    String updatePlantName=updateParameters[0];
                    int rarity = Integer.parseInt(updateParameters[1]);

                    Prep0301.Plant updatePlant = plants.get(updatePlantName);
                    if (updatePlant !=null){
                        updatePlant.setRarity(rarity);
                    }else{
                        System.out.println("Error");
                    }
                    break;
                case "Reset":
                    String resetPlantName = commandAndParameters[1];
                    Prep0301.Plant resetPlant = plants.get(resetPlantName);
                    if (resetPlant != null) {
                        resetPlant.resetRating();
                    }else{
                        System.out.println("Error");
                    }
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

            command = scanner.nextLine();

        }
        System.out.println("Plants for the exhibition:");

        plants.values()
                .stream()
                .sorted((a,b)-> {
                    if (a.getRarity() != b.getRarity()){
                        return Integer.compare(b.getRarity(), a.getRarity());
                    }else{
                        return Double.compare(b.getAverageRating(),a.getAverageRating());

                    }
                })
        .map(p ->" "+ p.getName() + "Rarity: " + p.getRarity() + "Rating: " + String.format("%.2f",p.getAverageRating()))
                .forEach(System.out::println);




    }
}