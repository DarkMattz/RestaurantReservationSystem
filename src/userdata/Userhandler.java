package userdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Userhandler {
	
	private User user = null;
	String regexEmail = "^(.+)@(\\S+)$";
	
	public String register(String email, String name, String password) {
		
		boolean isEmailValid = false;
		boolean isNameValid = false;
		boolean isPassValid = false;
		
		boolean doILoveYou = true;
		
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
		}
		
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
		
		if(!isEmailValid) {
			
			System.out.println("Email is not valid");
		}
		
		if(!isNameValid) {
			
			System.out.println("Username is not valid");
		}
		
		if(!isPassValid) {
			
			System.out.println("Password is not valid");
		}
		
			
		if(isEmailValid && isNameValid && isPassValid) {
			
			return null;
		}
		
		return "Register data is incorrect !";
	}
	
	public String login(String email, String password) {
		
		boolean isEmailValid = false;
		boolean isPassValid = false;
		
		if(email.isEmpty()) {
			
			return "Input your Email address !";
		}else {
			
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
			
		}
		
		
		
		return null;
	}
	
	public String logout() {
		
		return null;
	}
	
	public String removeUser(String id) {
		
		boolean isIdValid;
		
		if(id.isEmpty()) {
			
			return "Input your id to Continue !";
		}
		
		
		return null;
	}
	
	public Userhandler() {
		
	}

}
