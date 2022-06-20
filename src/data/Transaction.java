package data;

public class Transaction {

	private String transactionId;
	private String customerId;
	private Integer tableNumber;
	private String foodId;
	private Integer date;
	
	public Transaction(String transactionId, String customerId, Integer tableNumber, String foodId, Integer date) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.tableNumber = tableNumber;
		this.foodId = foodId;
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

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}
}
