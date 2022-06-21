package data;

public class Waiter {
    public String waiterID;
    public String waiterName;

    public Waiter(String waiterID, String waiterName) {
        this.waiterID = waiterID;
        this.waiterName = waiterName;
    }

    public String getWaiterID() {
        return waiterID;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }
}
