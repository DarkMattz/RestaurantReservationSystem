package data;

import java.util.ArrayList;

public class TransactionHandler {
	
	private ArrayList<Transaction> transaction = new ArrayList<>();
	
	public void NewTransaction(String customerId, Integer tableNumber, Vector<Food> food, Integer date) {
		String transactionId = "TR" + (int)Math.ceil(Math.random()*10) + (int)Math.ceil(Math.random()*10) + (int)Math.ceil(Math.random()*10);
		
		transaction.add(new Transaction(transactionId, customerId, tableNumber, food, date));
	}
	
	public void DeleteTransaction(String transactionId) {
		
		for(int i = 0; i < transaction.size(); i++) {
			Transaction getTransaction = transaction.get(i);
			
			if(getTransaction.getTransactionId().equals(transactionId)) {
				transaction.remove(i);
				break;
			}
		}
	}
	
	public int CalculateIncome(String transactionId) {
		int income = 0;
		int target = 0;
		
		for(int i = 0; i < transaction.size(); i++) {
			Transaction getTransaction = transaction.get(i);
			
			if(getTransaction.getTransactionId().equals(transactionId)) {
				target = i;
				break;
			}
		}
		
		for(int i = 0; i < transaction.get(target).getFoods().size(); i++) {
			income += transaction.get(target).getFoods().get(i).getFoodPrice();
		}
		
		return income;
	}
}
