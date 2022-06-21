package controller;

import data.*;
import userdata.Admin;
import userdata.Customer;
import userdata.User;
import userdata.UserHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private Customer loggedInCustomer = null;
    private Admin loggedInAdmin = null;
    private UserHandler userHandler = new UserHandler();
    private TransactionHandler transactionHandler = new TransactionHandler();
    private TableHandler tableHandler = new TableHandler();
    private FoodHandler foodHandler = new FoodHandler();
    
    private ArrayList<Customer> customers = userHandler.getAllCust();
    private ArrayList<Food> foods = foodHandler.getAllFood();
    private ArrayList<Table> tables = tableHandler.getAllTable();
    private ArrayList<Transaction> transactions = transactionHandler.getAllTransaction();

    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new App().run();
    }

    public void run(){

        //Show first menu
        int input;

        while(true){
        	System.out.println("");
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
                    System.out.println("Thank you for using our service");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please input from 1 to 3");
            }
        }
    }

    private void customer() {
        int input;
        do {
        	System.out.println("");
            System.out.println("Hello Customer!!!");
            System.out.println("~~~~~~~~~~~~~~~~~");
            System.out.println("1. Register as a new Customer");
            System.out.println("2. Reserve a place");
            System.out.println("3. Edit your profile");
            System.out.println("4. Go back/Logout");
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
                case 4:
                	loggedInCustomer = null;
                	break;
                default:
                    System.out.println("Please input from 1 to 4");
            }
        } while (input != 4);
    }

    private void reserve() {
    	System.out.println("");
    	System.out.println("RESERVE A TABLE");
    	System.out.println("=============================");
    	
    	if(loggedInCustomer != null || loginCustomer()){
    		String customerId = loggedInCustomer.getEmail();
    		
            int people = -1;
            do {
            	System.out.printf("Please enter the number of seats needed: ");
            	try {
					people = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
            } while (people < 1 || people > 10);
            
            viewAvailableTable(people);
            
            int tableNumber = -1;
            String tableError;
            do {
            	System.out.printf("Please choose the tableNumber: ");
            	try {
            		tableNumber = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
            	
            	tableError = tableHandler.isValidTable(people, tableNumber);
            	
            	if(tableError!=null) {
            		System.out.println(tableError);
            	}
            	
            } while (tableError != null);
            
            ArrayList<Food> orderedFood = new ArrayList<Food>();
            String foodIndex;
            
            do {
				viewAllMenu();
				
				System.out.printf("Please input food number [type 'finish' to finish your order]: ");
				foodIndex = scan.nextLine();
				
				if (!foodIndex.equalsIgnoreCase("finish")) {
					int index = Integer.parseInt(foodIndex);
					if(index < 0 || index > foods.size()) {
						System.out.println("Please enter a valid number [1-"+foods.size()+"]");
					}else{
						Food i = foods.get(index-1);
						orderedFood.add(i);
						System.out.printf("%s has been added to your order!\n", i.getFoodName());
					}
				}else if(foodIndex.equalsIgnoreCase("finish") && orderedFood.isEmpty()){
					System.out.println("You need to order a food first!");
					foodIndex = "noFinish";
				}
				
			} while (!foodIndex.equalsIgnoreCase("finish"));
            
            transactionHandler.addTransaction(customerId, tableNumber, orderedFood);
            tableHandler.changeToNotEmpty(tableNumber);
            
            System.out.println("Your Reservation has been made!");
            pressEnter();
        }
    }

    private void editProfile() {
        
        if(loggedInCustomer != null || loginCustomer()){
            int input = 0;
            do {
            	System.out.println("");
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
                    	 String name, nameError;
                         
                         do {
                         	System.out.print("Input your new name: ");
                         	name = scan.nextLine();
                             nameError = userHandler.isNameValid(name);
                             
                             if(nameError != null){
                             	System.out.println(nameError);
                             }
                             
                         } while (name.isEmpty() || nameError != null);        

                        userHandler.editName(loggedInCustomer, name);
                        System.out.println("Your name has been successfully updated!");
                        pressEnter();
                        
                        break;
                    case 2:
                    	String phone, phoneError;
                    	
                    	do {
                        	System.out.print("Input your new phone number: ");
                            phone = scan.nextLine();
                            phoneError = userHandler.isPhoneValid(phone);
                            
                            if(phoneError != null){
                            	System.out.println(phoneError);
                            }
                            
                        } while (phone.isEmpty() || phoneError != null);   

                    	userHandler.editPhone(loggedInCustomer, phone);
                    	System.out.println("Your phone has been successfully updated!");
                        pressEnter();
                    	
                        break;
                    case 3:
                        String password, passwordError;

                        do {
                            System.out.print("Input your new password [Must not be blank]: ");
                            password = scan.nextLine();
                            passwordError = userHandler.isPasswordValid(password);
                            
                            if(passwordError != null){
                            	System.out.println(passwordError);
                            }
                            
                        } while (password.isEmpty() || passwordError != null);

                        userHandler.editPass(loggedInCustomer, password);
                        System.out.println("Your password has been successfully updated!");
                        pressEnter();
                        
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Please input from 1 to 4");

                }
            } while (input != 4);
        }
    }
    
    private void register() {
    	System.out.println("");
        System.out.println("REGISTER CUSTOMER");
        System.out.println("===============================");
        
        String email, emailError;

        do {
            System.out.print("Input your email [Must not be blank]: ");
            email = scan.nextLine();
            emailError = userHandler.isValidNewEmail(email);
            
            if (emailError != null) {
				System.out.println(emailError);
			}
            
        } while (email.isEmpty() || emailError != null);

        String password, passwordError;

        do {
            System.out.print("Input your password [8-20 Characters]: ");
            password = scan.nextLine();
            passwordError = userHandler.isPasswordValid(password);
           
            if(passwordError != null){
            	System.out.println(passwordError);
            }
            
        } while (password.isEmpty() || passwordError != null);

        String name, nameError;
        
        do {
        	System.out.print("Input your name: ");
        	name = scan.nextLine();
            nameError = userHandler.isNameValid(name);
            
            if(nameError != null){
            	System.out.println(nameError);
            }
            
        } while (name.isEmpty() || nameError != null);        

        String phone, phoneError;
        
        do {
        	System.out.print("Input your phone [9-13 characters]: ");
            phone = scan.nextLine();
            phoneError = userHandler.isPhoneValid(phone);
            
            if(phoneError != null){
            	System.out.println(phoneError);
            }
            
        } while (phone.isEmpty() || phoneError != null);   

        userHandler.registerCustomer(email, name, password, phone);
        
        System.out.println("User has been registered!");
        
        pressEnter();
    }

    private boolean loginCustomer() {
    	customers = userHandler.getAllCust();
    	
        if(!customers.isEmpty()) {
        	System.out.println("");
            System.out.println("LOGIN CUSTOMER");
            System.out.println("===============================");
            do {
                String email, emailError;

                do {
                    System.out.print("Input your email [Must not be blank | press 0 to quit]: ");

                    email = scan.nextLine();
                    emailError = userHandler.isValidEmail(email);
                    
                    if (email.equals("0")) {
                        return false;
                    }else if(emailError != null){
                    	System.out.println(emailError);
                    }
                    
                } while (emailError!=null);

                String password;

                do {
                    System.out.print("Input your password [Must not be blank | press 0 to quit]: ");
                    password = scan.nextLine();
                    
                    if (password.equals("0")) {
                        return false;
                    }
                    
                } while (password.isEmpty());
                
                loggedInCustomer = userHandler.customerLogin(email, password);
                
                if(loggedInCustomer == null) {
                	System.out.println("Failed to Log In! Please check your email / password. ");
                	return false;
                }else {
                	System.out.println("Successfully logged in...");
                	pressEnter();
                	return true;
                }

            } while (true);
        } else {
            System.out.println("\nNo customer in the system, please register yourself first!");
            pressEnter();
            return false;
        }
    }

    private void manager() {
    	if(loggedInAdmin != null || loginManager()){
	        int input;
	        do {
	        	System.out.println("");
	            System.out.println("Hello Manager!!!");
	            System.out.println("~~~~~~~~~~~~~~~~~");
	            System.out.println("1. View all registered customers");
	            System.out.println("2. Manage tables");
	            System.out.println("3. Manage menus");
	            System.out.println("4. Transaction manager");
	            System.out.println("5. Go back/Logout");
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
	                	loggedInAdmin = null;
	                    break;
	                default:
	                    System.out.println("Please input from 1 to 5");
	            }
	
	        } while(input != 5);
    	}
    }
    
    private boolean loginManager() {
        String email, emailError;
        
        System.out.println("");
        System.out.println("LOGIN MANAGER");
        System.out.println("===============================");

        do {
            System.out.print("Input your email [Must not be blank | press 0 to quit]: ");

            email = scan.nextLine();
            emailError = userHandler.isValidEmail(email);
            
            if (email.equals("0")) {
                return false;
            }else if(emailError != null){
            	System.out.println(emailError);
            }
            
        } while (emailError!=null);

        String password;

        do {
            System.out.print("Input your password [Must not be blank | press 0 to quit]: ");
            password = scan.nextLine();
            
            if (email.equals("0")) {
                return false;
            }
            
        } while (password.isEmpty());

        loggedInAdmin = userHandler.adminLogin(email, password);
        
        if(loggedInAdmin == null) {
        	System.out.println("Failed to Log In! Please check your email / password. ");
        	return false;
        }else {
        	System.out.println("Successfully logged in...");
        	pressEnter();
        }
        
        return true;
    }

    private void transactionManager() {
    	int input;

        do{
        	System.out.println("");
            System.out.println("Transaction Manager");
            System.out.println("~~~~~~~~~~~~~~~~~");
            System.out.println("1. View all transactions");
            System.out.println("2. Remove transaction");
            System.out.println("3. Back");
            System.out.print(">> ");

            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                input = 0;
            }

            switch (input) {
                case 1:
                	viewAllTransactions();
                    break;
                case 2:
                	removeTransactions();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please input from 1 to 3");
            }
        }while (input != 3);
    }
    
    private void removeTransactions() {
    	viewAllTransactions();
    	
    	int index = -1;
    	
    	do {
			System.out.print("Please input the transaction index [1-"+transactions.size()+"]: ");
			try {
				index = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (index < 0 || index > foods.size());
    	
    	transactionHandler.removeTransaction(transactions.get(index-1).getTransactionId());
    	
    	System.out.println("Transactions has been successfully deleted!");
    	
    	pressEnter();
    }

    private void manageMenu() {
        int input;

        do{
        	System.out.println("");
            System.out.println("Menu Management");
            System.out.println("~~~~~~~~~~~~~~~~~");
            System.out.println("1. Add new menu");
            System.out.println("2. View all menus");
            System.out.println("3. Remove menu");
            System.out.println("4. Go back");
            System.out.print(">> ");

            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                input = 0;
            }

            switch (input) {
                case 1:
                	addMenu();
                    break;
                case 2:
                	viewAllMenu();
                	pressEnter();
                    break;
                case 3:
                	removeMenu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please input from 1 to 4");
            }
        }while (input != 4);
    }
    
    private void addMenu() {
    	
    	System.out.println("");
    	System.out.println("ADD MENU");
    	System.out.println("==================================");
    	
    	foods = foodHandler.getAllFood();
    	
    	String foodName;
    	Integer foodPrice = -1;
    	
    	do {
			System.out.print("Please enter the food name [5-20 Characters]: ");
			
			foodName = scan.nextLine();
			
		} while (foodName.length() < 5 || foodName.length() > 20);
    	
    	do {
			System.out.print("Please enter the food price [Minimal price is 10000]: ");
			
			try {
				foodPrice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			
		} while (foodPrice < 10000);
    	
    	foodHandler.addFood(foodName, foodPrice);
    	
    	System.out.println("Food has successfully created!");
    	pressEnter();
    }
    
    private void removeMenu() {
    	System.out.println("");
    	System.out.println("REMOVE MENU");
    	System.out.println("==================================");
    	viewAllMenu();
    	
    	int index = -1;
    	
    	do {
			System.out.print("Please input the food index [1-"+foods.size()+"]: ");
			try {
				index = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (index < 0 || index > foods.size());
    	
    	foodHandler.removeFood(foods.get(index-1).getFoodId());
    	
    	System.out.println("Food has been successfully deleted!");
    	
    	pressEnter();
    }

    private void manageTables() {
    	int input;

        do{
        	System.out.println("");
            System.out.println("Table Management");
            System.out.println("~~~~~~~~~~~~~~~~~");
            System.out.println("1. Add new table");
            System.out.println("2. View all tables");
            System.out.println("3. Remove table");
            System.out.println("4. Go back");
            System.out.print(">> ");

            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                input = 0;
            }

            switch (input) {
                case 1:
                	addNewTable();
                    break;
                case 2:
                	viewAllTable();
                	pressEnter();
                    break;
                case 3:
                	removeTable();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please input from 1 to 4");
            }
        }while (input != 4);
    }
    
    private void addNewTable() {
    	
    	System.out.println("");
    	System.out.println("ADD NEW TABLE");
    	System.out.println("==================================");
    	
    	tables = tableHandler.getAllTable();
    	
    	int tableNumber = tables.size()+1;
    	
    	int tableCapacity = -1;
    	
    	do {
			System.out.print("Please enter the capacity [2-10]: ");
			
			try {
				tableCapacity = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			
		} while (tableCapacity < 2 || tableCapacity > 10);
    	
    	tableHandler.addTable(tableNumber, tableCapacity);
    	
    	System.out.println("Table has successfully added!");
    	pressEnter();
    }
    
    private void removeTable() {
    	
    	System.out.println("");
    	System.out.println("REMOVE TABLE");
    	System.out.println("==================================");
    	
    	viewAllTable();
    	
    	int tableNumber = -1;
    	
    	do {
			System.out.print("Please input the Table Number [1-"+tables.size()+"]: ");
			try {
				tableNumber = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (tableNumber < 0 || tableNumber > tables.size());
    	
    	tableHandler.removeTable(tables.get(tableNumber-1).getTableNumber());
    	
    	System.out.println("Table has been successfully deleted!");
    	
    	pressEnter();
    }

    private void viewAllCustomers() {
    	customers = userHandler.getAllCust();
    	
    	System.out.println("");
    	System.out.println("+================================================================================+");
        System.out.println("|                             ALL REGISTERED CUSTOMERS                           |");
        System.out.println("+=====+============================+=========================+===================+");
    	System.out.println("| No. | Customer Email             | Customer Name           | Customer Phone    |");
    	System.out.println("+=====+============================+=========================+===================+");
        if (customers.isEmpty()) {
        	System.out.println("|                                                                                |");
        	System.out.println("|                               NO CUSTOMER REGISTERED                           |");
        	System.out.println("|                                                                                |");
		}else {
			int index = 1;
	        for (Customer customer : customers) {
	        	System.out.printf("| %-4d| %-27s| %-24s| %-18s|\n", index, customer.getEmail(), customer.getName(), customer.getPhone());
	            index++;
	        }
		}
        System.out.println("+=====+============================+=========================+===================+");
        
        pressEnter();
    }
    
    private void viewAllTransactions() {
    	transactions = transactionHandler.getAllTransaction();
    	
    	System.out.println("");
    	System.out.println("+============================================================================================================================================+");
        System.out.println("|                                                                   ALL TRANSACTIONS                                                         |");
        System.out.println("+=====+=======================+============================+==========+====================+==========================+======================+");
    	System.out.println("| No. | Transaction ID        | Customer Name              | Table No | Items Total        | Total Income             | Transaction Date     |");
    	System.out.println("+=====+=======================+============================+==========+====================+==========================+======================+");
    	if (transactions.isEmpty()) {
        	System.out.println("|                                                                                                                                        |");
        	System.out.println("|                                                             NO TRANSACTIONS                                                            |");
        	System.out.println("|                                                                                                                                        |");
		}else {
			int index = 1;
	        for (Transaction transaction : transactions) {
	        	System.out.printf("| %-4d| %-22s| %-27s| %-9d| %-19s| %-25s| %-21s|\n", 
	        			index, transaction.getTransactionId(), 
	        			userHandler.getCustomerName(transaction.getCustomerId()),
	        			transaction.getTableNumber(), transaction.getFoods().size() + "item(s)", 
	        			"Rp. "+transactionHandler.calculateIncome(transaction),
	        			transaction.getDate().toString());
	            index++;
	        }
		}
        
        System.out.println("+=====+=======================+============================+==========+====================+==========================+======================+");
    	
    }
    
    private void viewAllMenu() {
    	foods = foodHandler.getAllFood();
    	
    	System.out.println("");
    	System.out.println("+===================================================================+");
        System.out.println("|                             ALL MENU                              |");
        System.out.println("+=====+================+========================+===================+");
    	System.out.println("| No. | Food ID        | Food Name              | Food Price        |");
    	System.out.println("+=====+================+========================+===================+");
    	if (foods.isEmpty()) {
    		System.out.println("|                                                                   |");
    		System.out.println("|                           MENU IS EMPTY                           |");
    		System.out.println("|                                                                   |");
		}else {
			int index = 1;
	        for (Food food : foods) {
	        	System.out.printf("| %-4d| %-15s| %-23s| %-18s|\n", index, food.getFoodId(), food.getFoodName(), "Rp. "+food.getFoodPrice());
	            index++;
	        }
		}
        
        System.out.println("+=====+================+========================+===================+");

    }
    
    private void viewAllTable() {
    	tables = tableHandler.getAllTable();
    	
    	System.out.println("");
    	System.out.println("+===============================================================+");
        System.out.println("|                          ALL TABLE                            |");
        System.out.println("+==============+========================+=======================+");
    	System.out.println("| Table Number | Table Capacity         | Is Available          |");
    	System.out.println("+==============+========================+=======================+");
        if(tables.isEmpty()) {
        	System.out.println("|                                                               |");
        	System.out.println("|                      NO TABLE AVAILABLE                       |");
        	System.out.println("|                                                               |");
        }else {
            for (Table table : tables) {
            	String reserved = table.isEmpty() ? "YES" : "NO";
            	
            	System.out.printf("| %-13d| %-23d| %-22s|\n", table.getTableNumber(), table.getCapacity(), reserved);
            }
        }
        System.out.println("+==============+========================+=======================+");

    }
    
    private void viewAvailableTable(int people) {
    	tables = tableHandler.getAllTable();
    	
    	System.out.println("");
    	System.out.println("+===============================================================+");
        System.out.println("|                       AVAILABLE TABLE                         |");
        System.out.println("+==============+========================+=======================+");
    	System.out.println("| Table Number | Table Capacity         | Is Available          |");
    	System.out.println("+==============+========================+=======================+");
        for (Table table : tables) {
        	if(!table.isEmpty() && table.getCapacity()>=people) {
        		System.out.printf("| %-13d| %-23d| %-22s|\n", table.getTableNumber(), table.getCapacity(), "YES");
        	}
        }
        System.out.println("+==============+========================+=======================+");
    }
    
    private void pressEnter() {
    	System.out.println("Press Enter to continue ...");
    	scan.nextLine();
    }

}
