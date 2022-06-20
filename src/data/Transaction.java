package data;

public class Transaction {

	private String transactionId;
	private String customerId;
	private Integer tableNumber;
	private Food[] foods;
	private Integer date;
	
	public Transaction(String transactionId, String customerId, Integer tableNumber, Food[] foods, Integer date) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.tableNumber = tableNumber;
		this.foods = foods;
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

	public Food[] getFoods() {
		return foods;
	}

	public void setFoodId(Food[] foods) {
		this.foods = foods;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}
}
