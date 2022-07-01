package database;

import userdata.Admin;
import userdata.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseUserHandler {
    private Connect con = Connect.getConnection();

    public boolean checkEmail(String email) {
        ResultSet res = con.executeQuery("SELECT * FROM users WHERE BINARY email = '" + email + "'");
        try {
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void pushData(String email, String name, String pass, String phone) {
        con.executeUpdate("INSERT INTO `users`(`email`, `password`, `name`, `phone`, `isAdmin`) VALUES ('"+ email +"','"+ pass +"','" + name + "','"+ phone +"','"+0+"')");
    }

    public ArrayList<Customer> getCustomerData() {
        ArrayList<Customer> customers = new ArrayList<>();
        ResultSet res = con.executeQuery("SELECT * FROM `users`");
        try {
            while (res.next()){
                if(res.getBoolean("isAdmin")){
                    continue;
                }
                customers.add(new Customer(res.getString("email"), res.getString("password"), res.getString("name"), res.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public String getName(String email) {
        ResultSet res = con.executeQuery("SELECT * FROM `users` WHERE BINARY email = '" + email + "'");
        try {
            if(res.next()){
                return res.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer findCustomer(String email, String password) {
        ResultSet res = con.executeQuery("SELECT * FROM `users` WHERE BINARY email = '" + email + "' AND password = '" + password +"'");
        try {
            if(res.next()){
                return new Customer(res.getString("email"), res.getString("password"), res.getString("name"), res.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Admin findAdmin(String email, String password) {
        ResultSet res = con.executeQuery("SELECT * FROM `users` WHERE BINARY email = '" + email + "' AND password = '" + password +"' AND isAdmin = " + "1");
        try {
            if(res.next()){
                return new Admin(res.getString("email"), res.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editName(Customer customer, String name) {
        con.executeUpdate("UPDATE `users` SET `name`='"+ name +"' WHERE BINARY `email` = '" + customer.getEmail() + "'");
    }

    public void editPhone(Customer customer, String phone) {
        con.executeUpdate("UPDATE `users` SET `phone`='"+ phone +"' WHERE BINARY `email` = '" + customer.getEmail() + "'");
    }

    public void editPass(Customer customer, String pass) {
        con.executeUpdate("UPDATE `users` SET `password`='"+ pass +"' WHERE BINARY `email` = '" + customer.getEmail() + "'");
    }

}