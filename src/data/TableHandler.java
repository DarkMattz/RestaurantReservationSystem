package data;

import java.util.ArrayList;

public class TableHandler {

	private ArrayList<Table> table = new ArrayList<>();
	
	public ArrayList<Table> ReturnTable() {
		return table;
	}
	
	public void AddTable(Integer tableSize) {
		int lastNumber = table.get(table.size()-1).getTableNumber();
		
		table.add(new Table(lastNumber, tableSize));
	}
	
	public void RemoveTable(Integer tableNumber) {
		
		for(int i = 0; i < table.size(); i++) {
			Table getTable = table.get(i);
			
			if(getTable.getTableNumber() == tableNumber) {
				table.remove(i);
				break;
			}
		}
	}
	
	public String ValidTable(Integer people, Integer tableNumber) {
		int flag = 0;
		int number = 0;
		
		for(int i = 0; i < table.size(); i++) {
			Table getTable = table.get(i);
			
			if(getTable.getTableNumber() == tableNumber) {
				flag = 1;
				number = i;
			}
		}
		
		if(flag == 0) {
			return "Table is not Available";
		}
		
		if(table.get(number).getCapacity() < people) {
			return "Table is not Available";
		}
		
		else {
			return null;
		}
		
	}
}
