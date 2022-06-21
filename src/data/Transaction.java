package data;

import java.sql.Date;
import java.util.ArrayList;

public class Transaction {

	private String transactionId;
	private String customerId;
	private Integer tableNumber;
	private ArrayList<Food> food;
	private Date date;
	
	public Transaction(String transactionId, String customerId, Integer tableNumber, ArrayList<Food> food, Date date) {
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

	public ArrayList<Food> getFoods() {
		return food;
	}

	public void setFoodId(ArrayList<Food> food) {
		this.food = food;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
