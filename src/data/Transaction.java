package data;

import java.util.Vector;

public class Transaction {

	private String transactionId;
	private String customerId;
	private Integer tableNumber;
	private Vector<Food> food = new Vector<>();
	private Integer date;
	
	public Transaction(String transactionId, String customerId, Integer tableNumber, Vector<Food> food, Integer date) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.tableNumber = tableNumber;
		this.food = food;
		this.date = date;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Vector<Food> getFoods() {
		return food;
	}

	public void setFoodId(Vector<Food> food) {
		this.food = food;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}
}
