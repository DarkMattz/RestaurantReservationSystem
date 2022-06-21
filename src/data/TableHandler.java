package data;

import database.DatabaseTransactionHandler;

import java.util.ArrayList;

public class TableHandler {

	private DatabaseTransactionHandler dbth = new DatabaseTransactionHandler();
	
	public ArrayList<Table> getAllTable() {
		return dbth.ShowTable();
	}
	
	public void addTable(int tableNumber, Integer tableSize) {
		dbth.AddTable(tableNumber, tableSize);
	}

	public void removeTable(Integer tableNumber) {
		dbth.DeleteTable(tableNumber);
	}
	
	public String isValidTable(Integer people, Integer tableNumber) {
		Table table = dbth.SearchTable(tableNumber);
		if(table == null){
			return "No table found";
		} else if(table.getCapacity() < people){
			return "Table capacity is not enough!";
		} else {
			return null;
		}
	}

	public void changeToNotEmpty(int tableNumber){
		dbth.changeTableStatus(tableNumber);
	}
}
