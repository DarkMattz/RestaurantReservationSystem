package data;

import database.DatabaseTransactionHandler;

import java.util.ArrayList;

public class FoodHandler {

	private DatabaseTransactionHandler dbth = new DatabaseTransactionHandler();
	
	public void AddFood(String foodId, String foodName, Integer foodPrice) {
		dbth.AddFood(foodId, foodName, foodPrice);
	}

	public void DeleteFood(String foodId) {
		dbth.DeleteFood(foodId);
	}
	
	public ArrayList<Food> ShowFood() {
		return dbth.ShowFood();
	}
}
