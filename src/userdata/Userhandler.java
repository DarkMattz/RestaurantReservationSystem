package userdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Userhandler {
	
	private User user = null;
	
	DatabaseUserHandler database = new DatabaseUserHandler();
	
	String regexEmail = "^(.+)@(\\S+)$";
	
	public Userhandler() {
		
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
	
	public String registerUser(String email, String name, String pass, String phone) {
		
		if(database.PushData()) {
			
			return null;
		}else {
			
			return "Failed !";
		}
	}
	
	public Customer customerLogin(String email, String password) {
		
		Customer customer = new Customer();
		
		if(database.isEmailExist(email) && database.isPassTrue(password)) {
			
			return customer;
		}else {
			
			return null;
		}
		
	}
	
	public Admin adminLogin(String email, String password) {
		
		Admin admin = new Admin();
		
		if(database.isEmailExist(email) && database.isPassTrue(password)) {
			
			return admin;
		}else {
			
			return null;
		}
	}
	
	public String logout() {
		
		user = null;
		
		return "User has been logged out";
	}
	
}
