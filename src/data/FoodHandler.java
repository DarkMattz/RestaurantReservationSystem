package data;

import java.util.Vector;

public class FoodHandler {

	private Vector<Food> food = new Vector<>();
	
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
	
	public void UpdateFood(String foodId, String foodName, Integer foodPrice) {
		
		int input = 0;
		
		for(int i = 0; i < food.size(); i++) {
			Food getFood = food.get(i);
			
			if(getFood.getFoodId().equals(foodId)) {
				input = i;
				break;
			}
		}
		
		Food getFood = food.get(input);
		
		getFood.setFoodId(foodId);
		getFood.setFoodName(foodName);
		getFood.setFoodPrice(foodPrice);
	}
}
