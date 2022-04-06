import data.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Table> tables = new ArrayList<>();
    private ArrayList<Food> menu = new ArrayList<>();
    private ArrayList<Waiter> waiters = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    private Customer loggedInCustomer = null;

    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new App().run();
    }

    public void run(){

        //Get all data from CSV files
        getData();

        //Show first menu
        int input;

        while(true){
            System.out.println("WELCOME TO THE RESTAURANT");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Customer Menu");
            System.out.println("2. Manager Menu");
            System.out.println("3. Exit");
            System.out.print(">> ");

            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                input = 0;
            }

            switch (input){
                case 1:
                    customer();
                    break;
                case 2:
                    manager();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please input from 1 to 3");
            }
        }
    }

    private void getData(){
//
//        Scanner reader = null;
//
//        //Create save directory
//        File saveDir = new File("SaveFile");
//
//        saveDir.mkdir();
//
//        //Get customer files
//        File customerSaveFile = new File("SaveFile\\Customer.csv");
//
//        if(!customerSaveFile.exists()){
//            try {
//                customerSaveFile.createNewFile();
//            } catch (IOException e) {
//                System.out.println(e.toString());
//            }
//        }
//
//        try {
//            reader = new Scanner(customerSaveFile);
//        } catch (FileNotFoundException ignored){
//        }
//

    }

    private void customer() {
        int input;
        do {
            System.out.println("Hello Customer!!!");
            System.out.println("~~~~~~~~~~~~~~~~~");
            System.out.println("1. Register as a new Customer");
            System.out.println("2. Reserve a place");
            System.out.println("3. Edit your profile");
            System.out.println("4. Go back");
            System.out.print(">> ");

            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                input = 3;
            }

            switch (input) {
                case 1:
                    register();
                    break;
                case 2:
                    reserve();
                    break;
                case 3:
                    editProfile();
                    break;
                default:
                    System.out.println("Please input from 1 to 4");
            }
        } while (input != 4);
    }

    private void reserve() {

    }

    private void editProfile() {
        if(loggedInCustomer != null || login()){
            int input = 0;
            do {
                System.out.println("Edit your profile");
                System.out.println("~~~~~~~~~~~~~~~~~");
                System.out.println("1. Edit your name");
                System.out.println("2. Edit your phone number");
                System.out.println("3. Edit your password");
                System.out.println("4. Go back");
                System.out.print(">> ");


                try {
                    input = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please input from 1 to 4");
                }

                switch (input) {
                    case 1:
                        String name;

                        System.out.print("Input your name: ");
                        name = scan.nextLine();

                        loggedInCustomer.setName(name);
                        break;
                    case 2:
                        String phone;

                        System.out.print("Input your Phone: ");
                        phone = scan.nextLine();

                        loggedInCustomer.setPhone(phone);
                        break;
                    case 3:
                        String password;

                        do {
                            System.out.print("Input your password [Must not be blank]: ");
                            password = scan.nextLine();
                        } while (password.isBlank());

                        loggedInCustomer.setPassword(password);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Please input from 1 to 4");

                }
            } while (input != 4);
        }
    }

    private boolean login() {
        if(!customers.isEmpty()) {
            do {
                String email;

                do {
                    System.out.print("Input your email [Must not be blank | press 0 to quit]: ");

                    email = scan.nextLine();
                } while (email.isBlank());

                if (email.equals("0")) {
                    return false;
                }

                String password;

                do {
                    System.out.print("Input your password [Must not be blank | press 0 to quit]: ");
                    password = scan.nextLine();
                } while (password.isBlank());

                if (password.equals("0")) {
                    return false;
                }

                for (Customer customer : customers) {
                    if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                        loggedInCustomer = customer;
                        return true;
                    } else {
                        System.out.println("Wrong email or password");
                    }
                }
            } while (true);
        } else {
            System.out.println("No customer in the system");
            return false;
        }
    }

    private void register() {
        String email;

        do {
            System.out.print("Input your email [Must not be blank]: ");
            email = scan.nextLine();

            for (Customer customer : customers) {
                if (customer.getEmail().equals(email)) {
                    System.out.println("Email already used");
                    email = "";
                }
            }
        } while (email.isBlank());

        String password;

        do {
            System.out.print("Input your password [Must not be blank]: ");
            password = scan.nextLine();
        } while (password.isBlank());

        String name;

        System.out.print("Input your name: ");
        name = scan.nextLine();

        String phone;

        System.out.print("Input your phone: ");
        phone = scan.nextLine();

        customers.add(new Customer(email, password, name, phone));
    }



    private void manager() {
        int input;
        do {
            System.out.println("Hello Manager!!!");
            System.out.println("~~~~~~~~~~~~~~~~~");
            System.out.println("1. View all registered customers");
            System.out.println("2. Manage tables");
            System.out.println("3. Manage menus");
            System.out.println("4. Transaction manager");
            System.out.println("5. Go back");
            System.out.print(">> ");

            try {
                input = Integer.parseInt(scan.nextLine());
            }  catch (NumberFormatException e){
                input = -1;
            }

            switch (input) {
                case 1:
                    viewAllCustomers();
                    break;
                case 2:
                    manageTables();
                    break;
                case 3:
                    manageMenu();
                    break;
                case 4:
                    transactionManager();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please input from 1 to 5");
            }

        } while(input != 5);
    }

    private void transactionManager() {
    }


    private void manageMenu() {
        int input;

        do{
            System.out.println("Menu Management");
            System.out.println("~~~~~~~~~~~~~~~~~");
            System.out.println("1. Add new menu");
            System.out.println("2. View all menus");
            System.out.println("3. Remove menu");
            System.out.println("4. Go back");

            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                input = 0;
            }

            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please input from 1 to 4");
            }
        }while (input != 4);
    }

    private void manageTables() {
    }

    private void viewAllCustomers() {
        System.out.println("All registered customers: ");
        for (Customer customer : customers) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Name: " + customer.getName());
            System.out.println("Phone: " + customer.getPhone());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

}
