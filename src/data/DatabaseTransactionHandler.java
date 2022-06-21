package data;

import java.util.ArrayList;
import java.util.Date;

public class DatabaseTransactionHandler {
	
	public DatabaseTransactionHandler() {
		// TODO Auto-generated constructor stub
	}

	//View = Show semua object dari database
	
	public ArrayList<Food> ShowFood(ArrayList<Food> food) {
		return food;
		// TODO Auto-generated method stub
	}
	
	public ArrayList<Table> ShowTable(ArrayList<Table> table) {
		return table;
		// TODO Auto-generated method stub
	}
	
	
	//Add
	
	public void AddFood(String foodId, String foodName, Integer foodPrice) {
		// TODO Auto-generated method stub
	}

	public void AddTable(int lastNumber, Integer tableSize) {
		// TODO Auto-generated method stub
	}

	public void AddTransaction(String transactionId, String customerId, Integer tableNumber, ArrayList<Food> food,
			Date date) {
		// TODO Auto-generated method stub
	}
	
	
	//Delete = Looping cari index, delete dari database
	
	public void DeleteFood(String foodId) {
		// TODO Auto-generated method stub
		
	}

	public void DeleteTable(Integer tableNumber) {
		// TODO Auto-generated method stub
		
	}
	
	public void DeleteTransaction(String transactionId) {
		// TODO Auto-generated method stub
	}
	
	//finders
	public int FindTransaction(String transactionId) {
		int index = 0;
		
		return index;
		// TODO Auto-generated method stub
		
	}

	public int CalculateIncome(int target) {
		int income = 0;
		
		//Looping Array Food dari Transaction ke-Target, return income
		
		return income;
		// TODO Auto-generated method stub
	}

	public int SearchTable(Integer tableNumber) {
		int flag = 0;
		
		//Searching. Jika tableNumber ada dalam table number object database, lanjut ke step selanjutnya. Jika tidak, flag 0.
		//Cek capacity. Jika kapasitas pada index tableNumber sama dengan/lebih besar dari kapasitas object index, flag = 1. Jika tidak, flag 0. 
		
		
		return flag;
		// TODO Auto-generated method stub
	}
}
