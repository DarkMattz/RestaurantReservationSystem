package database;

import data.Food;
import data.Table;
import data.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class DatabaseTransactionHandler {

	private Connect con = Connect.getConnection();

	public ArrayList<Food> ShowFood() {
		ArrayList<Food> foods = new ArrayList<>();

		ResultSet res = con.executeQuery("SELECT * FROM `food`");

		try {
			while (res.next()){
				foods.add(new Food(res.getString("ID"), res.getString("name"), res.getInt("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foods;
	}
	
	public ArrayList<Table> ShowTable() {
		ArrayList<Table> tables = new ArrayList<>();

		ResultSet res = con.executeQuery("SELECT * FROM `table`");

		try {
			while (res.next()){
				tables.add(new Table(res.getInt("number"), res.getInt("Capacity"), res.getBoolean("isEmpty")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tables;
	}
	
	
	//Add
	
	public void AddFood(String foodId, String foodName, Integer foodPrice) {
		con.executeUpdate("INSERT INTO `food`(`ID`, `name`, `price`) VALUES ('"+foodId+"','"+foodName+"',"+foodPrice+")");
	}

	public void AddTable(int tableNumber, Integer tableSize) {
		con.executeUpdate("INSERT INTO `table`(`number`, `capacity`, `isEmpty`) VALUES ("+tableNumber+", " + tableSize + ", 1)");
	}

	public void AddTransaction(String transactionId, String customerId, Integer tableNumber, ArrayList<Food> foods, Date date) {
		con.executeUpdate("INSERT INTO `transaction`(`ID`, `customerEmail`, `tableNumber`, `date`) VALUES ('"+transactionId+"','"+customerId+"',"+tableNumber+",'"+date+"')");
		for(Food food : foods){
			con.executeUpdate("INSERT INTO `orderedfood`(`transactionID`, `foodID`) VALUES ('"+transactionId+"','"+food.getFoodId()+"')");
		}
	}
	
	
	//Delete = Looping cari index, delete dari database
	
	public void DeleteFood(String foodId) {
		con.executeUpdate("DELETE FROM `food` WHERE ID = '" +foodId+"'");
		
	}

	public void DeleteTable(Integer tableNumber) {
		con.executeUpdate("DELETE FROM `table` WHERE number = " +tableNumber);
		
	}
	
	public void DeleteTransaction(String transactionId) {
		con.executeUpdate("DELETE FROM `transaction` WHERE ID = '" +transactionId+"'");
		con.executeUpdate("DELETE FROM `orderedfood` WHERE transactionID = '" +transactionId+"'");
	}


	public Table SearchTable(Integer tableNumber) {
		int flag = 0;
		
		//Searching. Jika tableNumber ada dalam table number object database, lanjut ke step selanjutnya. Jika tidak, flag 0.
		//Cek capacity. Jika kapasitas pada index tableNumber sama dengan/lebih besar dari kapasitas object index, flag = 1. Jika tidak, flag 0. 

		ResultSet res = con.executeQuery("SELECT * FROM `table` WHERE number = "+ tableNumber);
		try {
			if(res.next()){
				return new Table(res.getInt("number"), res.getInt("capacity"), res.getBoolean("isEmpty"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void changeTableStatus(int tableNumber) {
		con.executeUpdate("UPDATE `table` SET `isEmpty`='"+0+"' WHERE number =" + tableNumber);
	}


	public ArrayList<Transaction> fetchTransaction() {
		ArrayList<Transaction> trans = new ArrayList<>();
		ResultSet res = con.executeQuery("SELECT * FROM `transaction`");
		try {
			while (res.next()){
				String id = res.getString("ID");
				String email = res.getString("customerEmail");
				int tableNumber = res.getInt("tableNumber");
				Date date = res.getDate("date");
				trans.add(new Transaction(id, email, tableNumber, null, date));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Transaction transaction : trans){
			try {
				ArrayList<Food> foods = new ArrayList<>();
				ResultSet resFoods = con.executeQuery("SELECT * FROM `orderedfood` JOIN `food` ON orderedfood.foodID = food.ID WHERE transactionID = '"  + transaction.getTransactionId() + "'");
				while (resFoods.next()){
					foods.add(new Food(resFoods.getString("foodID"), resFoods.getString("name"), resFoods.getInt("price")));
				}
				transaction.setFoodId(foods);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trans;
	}
}
