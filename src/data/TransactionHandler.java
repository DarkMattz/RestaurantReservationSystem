package data;

import java.util.Vector;

public class TransactionHandler {
	
	private Vector<Transaction> transaction = new Vector<>();	
	
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
	
	public void ShowTransaction() {
		
		for(int i = 0; i < transaction.size(); i++) {
			Transaction getTransaction = transaction.get(i);
			java.util.Date time = new java.util.Date((long)getTransaction.getDate() *1000);
			
			System.out.println("Transaction ID: " + getTransaction.getTransactionId());
			System.out.println("Date: " + time);
			System.out.println("Customer ID: " + getTransaction.getCustomerId());
			System.out.println("Table Number: " + getTransaction.getTableNumber());
			System.out.println("Ordered Foods:");
			System.out.println(" " + getTransaction.getFoods());
			}
		}
	}
