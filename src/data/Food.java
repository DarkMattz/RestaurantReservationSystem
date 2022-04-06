package data;

public class Food {
    private String foodType;
    private String foodName;

    public Food(String foodType, String foodName) {
        this.foodType = foodType;
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getFoodName() {
        return foodName;
    }
}
