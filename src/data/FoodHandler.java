package data;

import java.util.ArrayList;

public class FoodHandler {

	private ArrayList<Food> food = new ArrayList<>();
	
	public void AddFood(String foodId, String foodName, Integer foodPrice) {
		food.add(new Food(foodId, foodName, foodPrice));
	}

	public void DeleteFood(String foodId) {
		for(int i = 0; i < food.size(); i++) {
			Food getFood = food.get(i);
			
			if(getFood.getFoodId().equals(foodId)) {
				food.remove(i);
				break;
			}
		}
	}
	
	public ArrayList<Food> ShowFood() {
		return food;
	}
}
