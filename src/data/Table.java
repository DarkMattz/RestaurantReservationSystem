package data;

public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isEmpty;

    public Table(int tableNumber, int capacity, boolean isEmpty) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isEmpty = isEmpty;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
