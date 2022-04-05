package data;

public class Customer {
    private String CustomerID, name, phone;
    private int numberReservation;

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumberReservation() {
        return numberReservation;
    }

    public void setNumberReservation(int numberReservation) {
        this.numberReservation = numberReservation;
    }
}
