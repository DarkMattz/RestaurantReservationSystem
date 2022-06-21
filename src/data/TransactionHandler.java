package data;

import java.util.ArrayList;

public class TransactionHandler {
	
	private DatabaseTransactionHandler dbth = new DatabaseTransactionHandler();
	
	public void NewTransaction(String customerId, Integer tableNumber, ArrayList<Food> food, Integer date) {
		String transactionId = "TR" + (int)Math.ceil(Math.random()*10) + (int)Math.ceil(Math.random()*10) + (int)Math.ceil(Math.random()*10);
		
		//transaction.add(new Transaction(transactionId, customerId, tableNumber, food, date));
		dbth.AddTransaction(transactionId, customerId, tableNumber, food, date);
		
	}
	
	public void DeleteTransaction(String transactionId) {
		/*
		for(int i = 0; i < transaction.size(); i++) {
			Transaction getTransaction = transaction.get(i);
			
			if(getTransaction.getTransactionId().equals(transactionId)) {
				transaction.remove(i);
				break;
			}
		}*/
		
		dbth.DeleteTransaction(transactionId);
	}
	
	public int CalculateIncome(String transactionId) {
		int income = 0;
		int target = 0;
		
		//Find Transaction id
		target = dbth.FindTransaction(transactionId);
		
		/*
		for(int i = 0; i < transaction.size(); i++) {
			Transaction getTransaction = transaction.get(i);
			
			if(getTransaction.getTransactionId().equals(transactionId)) {
				target = i;
				break;
			}
		}*/
		
		//Calculate Income from Database
		
		income = dbth.CalculateIncome(target);
		
		/*
		for(int i = 0; i < transaction.get(target).getFoods().size(); i++) {
			income += transaction.get(target).getFoods().get(i).getFoodPrice();
		}*/
		
		return income;
	}
}
