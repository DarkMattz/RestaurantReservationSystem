package userdata;

import database.DatabaseUserHandler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Userhandler {
	
	DatabaseUserHandler database = new DatabaseUserHandler();
	
	String regexEmail = "^(.+)@(\\S+)$";
	
	public Userhandler() {
		
	}
	
	ArrayList<Customer> getAllCust(){
		
		return database.getCustomerData();
	}
	
	public String isValidEmail(String email) {
		
		boolean isEmailValid = false;
		boolean isCheckEmailSuccess = false;
		
//		Validasi Email
		if(email.isEmpty()) {
			
			return "Input your email address !";
		}else{
			
			Pattern pattern = Pattern.compile(regexEmail);
			Matcher matcher = pattern.matcher(email);
			
			// Jika email sesuai dengan pattern regex
			if(matcher.matches()) {
	
				isEmailValid = true;
			}
			
			// Jika email tidak sesuai dengan pattern regex
			else {
				
				return "Email pattern is incorrect !";			
			}
			
			 //salah (isEmailExist), return false
			
			if(database.checkEmail(email)) {
				
				return "Email is already in use !";
			}else {
				
				isCheckEmailSuccess = true;
			}
			
		}
		
		if(isEmailValid && isCheckEmailSuccess) {
			
			return null;
		}
		
		return "Email is invalid";
	}
	
	public String isNameValid (String name) {
		
		boolean isNameValid = false;
		
//		Validasi nama
		if(name.isEmpty()) {
			return "Input your name !";
		}else{
			
			if(name.length() < 2 ) {
				
				return "Name is too short !";
			}else {
				
				isNameValid = true;
			}
		}
		
		return "Name is invalid !";
		
	}
	
	public String isPasswordValid(String password) {
		
		boolean isPassValid = false;
		
//		Validasi password
		if(password.isEmpty()) {
			
			return "Input your password !";
		}else {

			if(password.length() < 8 && password.length() > 20) {
				
				return "Password is too short !";
				
			}else {
				
				isPassValid = true;
			}

		}
		
		return "Password is invalid !";
	}
	
	public String isPhoneValid(String phone) {
		
		boolean isPhoneValid = false;
		
		if(phone.isEmpty()) {
			
			return "Input your phone number !";
		}else {
			
			if(phone.length() < 9 && phone.length() > 13) {
				
				return "Invalid phone number !";
			}else {
				
				isPhoneValid = true;
			}
		}
		
		return "Phone number is Invalid !";
	}
	
	public void registerCustomer(String email, String name, String pass, String phone) {
		database.pushData(email, name, pass, phone);
	}
	
	public Customer customerLogin(String email, String password) {
		
		Customer customer = database.findCustomer(email, password); //balikin customer
		
		return customer;
	}
	
	public Admin adminLogin(String email, String password) {
		
		Admin admin = database.findAdmin(email, password);
		
		return admin;
	}
	
	public void editName(Customer customer, String name) {
		
		database.editName(customer, name);
	}
	
	public void editPhone(Customer customer, String phone) {
		
		database.editPhone(customer, phone);
	}
	
	public void editPass(Customer customer, String pass) {
		
		database.editPass(customer, pass);
	}
	
	public String getCustomerName(String email) {
		
		return database.getName(email);
	}
}
