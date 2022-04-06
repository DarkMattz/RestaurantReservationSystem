package data;

import data.Customer;

import java.util.ArrayList;
import java.util.Calendar;

public class Transaction{
    public Customer customer;
    public Calendar date;
    public Table table;
    public Waiter waiter;
    public ArrayList<OrderedFood> foods;

    public Transaction(Customer customer, Calendar date, Table table, Waiter waiter, ArrayList<OrderedFood> foods) {
        this.customer = customer;
        this.date = date;
        this.table = table;
        this.waiter = waiter;
        this.foods = foods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Calendar getDate() {
        return date;
    }

    public Table getTable() {
        return table;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public ArrayList<OrderedFood> getFoods() {
        return foods;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void setFoods(ArrayList<OrderedFood> foods) {
        this.foods = foods;
    }
}
