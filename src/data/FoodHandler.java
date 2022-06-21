package data;

import database.DatabaseTransactionHandler;

import java.util.ArrayList;
import java.util.Random;

public class FoodHandler {

	private DatabaseTransactionHandler dbth = new DatabaseTransactionHandler();
	
	public void addFood(String foodName, Integer foodPrice) {
		String foodId = generateFoodID();
		dbth.AddFood(foodId, foodName, foodPrice);
	}
	
	public String generateFoodID() {
		return "FO" + (int)Math.floor(Math.random()*10) + (int)Math.floor(Math.random()*10) + (int)Math.floor(Math.random()*10);
	}

	public void removeFood(String foodId) {
		dbth.DeleteFood(foodId);
	}
	
	public ArrayList<Food> getAllFood() {
		return dbth.ShowFood();
	}
}
