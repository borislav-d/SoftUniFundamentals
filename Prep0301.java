import java.util.ArrayList;
import java.util.List;

public class Prep0301 {
    static class Plant {
        String name;
        int rarity;
        List<Double> rating;

        public Plant(String name, int rarity){
            this.name = name;
            this.rarity= rarity;
            this.rating= new ArrayList<>();

        }

        public String getName() {
            return name;
        }
        public void addRating (double rating){
            this.rating.add(rating);

        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }
       public void resetRating(){
            this.rating.clear();

       }

        public int getRarity() {
            return rarity;
        }
        public double getAverageRating(){
            if (this.rating.isEmpty()){
                return 0;
            }
            double averageRating = 0;
            for (Double rating : this.rating) {
                averageRating += rating;

            }
            averageRating = averageRating / this.rating.size();
        return averageRating;
        }
    }


}

