package data;

import java.util.ArrayList;

public class FoodHandler {

	private DatabaseTransactionHandler dbth = new DatabaseTransactionHandler();
	private ArrayList<Food> food = new ArrayList<>();
	
	public void AddFood(String foodId, String foodName, Integer foodPrice) {
		//food.add(new Food(foodId, foodName, foodPrice));
		dbth.AddFood(foodId, foodName, foodPrice);
	}

	public void DeleteFood(String foodId) {
		/*for(int i = 0; i < food.size(); i++) {
			Food getFood = food.get(i);
			
			if(getFood.getFoodId().equals(foodId)) {
				food.remove(i);
				break;
			}
		}*/
		dbth.DeleteFood(foodId);
	}
	
	public ArrayList<Food> ShowFood() {
		dbth.ShowFood(food);
		return food;
	}
}
