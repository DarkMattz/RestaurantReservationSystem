package data;

import database.DatabaseTransactionHandler;

import java.util.ArrayList;

public class TableHandler {

	private DatabaseTransactionHandler dbth = new DatabaseTransactionHandler();
	
	public ArrayList<Table> ReturnTable() {
		return dbth.ShowTable();
	}
	
	public void AddTable(int tableNumber, Integer tableSize) {
		dbth.AddTable(tableNumber, tableSize);
	}

	public void RemoveTable(Integer tableNumber) {
		dbth.DeleteTable(tableNumber);
	}
	
	public String ValidTable(Integer people, Integer tableNumber) {
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
