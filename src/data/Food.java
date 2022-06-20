package data;

public class Food {
    private String foodId;
    private String foodName;
    private Integer foodPrice;

    public Food(String foodId, String foodName, Integer foodPrice) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }
    
    public Integer getFoodPrice() {
    	return foodPrice;
    }
}
