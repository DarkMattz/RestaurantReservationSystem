package data;

import java.util.Vector;

public class TransactionHandler {
	
	private Vector<Transaction> transaction = new Vector<>();	
	
	public void NewTransaction(String transactionId, String customerId, Integer tableNumber, Food[] food, Integer date) {
		transaction.add(new Transaction(transactionId, customerId, tableNumber, food, date));
	}
	
	public void DeleteTransaction(String transactionId) {
		
		Integer inputDelete = null;
		
		for(int i = 0; i < transaction.size(); i++) {
			Transaction getTransaction = transaction.get(i);
			
			if(getTransaction.getTransactionId().equals(transactionId)) {
				inputDelete = i;
				break;
			}
		}
		
		transaction.remove(inputDelete);
	}
}
