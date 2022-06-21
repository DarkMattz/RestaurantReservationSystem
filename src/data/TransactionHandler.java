package data;

import database.DatabaseTransactionHandler;

import java.util.ArrayList;
import java.sql.Date;

public class TransactionHandler {
	
	private DatabaseTransactionHandler dbth = new DatabaseTransactionHandler();
	
	public void addTransaction(String customerId, Integer tableNumber, ArrayList<Food> food) {
		String transactionId = "TR" + (int)Math.ceil(Math.random()*10) + (int)Math.ceil(Math.random()*10) + (int)Math.ceil(Math.random()*10);
		dbth.AddTransaction(transactionId, customerId, tableNumber, food, new Date(System.currentTimeMillis()));
	}
	
	public void removeTransaction(String transactionId) {
		dbth.DeleteTransaction(transactionId);
	}

	public int calculateIncome(Transaction transaction){
		int value = 0;
		for(Food food : transaction.getFoods()){
			value+= food.getFoodPrice();
		}
		return value;
	}

	public ArrayList<Transaction> getAllTransaction(){
		return dbth.fetchTransaction();
	}
}
