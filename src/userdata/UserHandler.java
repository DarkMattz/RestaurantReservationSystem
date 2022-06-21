package userdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserHandler {
	
	private User user = null;
	
	public String register(String email, String name, String password) {
		
		String regexEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
		String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		
		boolean isEmailValid = false;
		boolean isNameValid = false;
		boolean isPassValid = false;
		
		boolean doILoveYou = true;
		
//		Validasi Email
		if(email.isEmpty()) {
			
			return "Input your email address !";
		}else{
			
			Pattern pattern = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
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
			
			Pattern pattern = Pattern.compile(regexPassword);
			Matcher matcher = pattern.matcher(email);

			if(password.length() < 8) {
				
				return "Password is too short !";
				
			}else if(matcher.matches()){
				
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
		
		return null;
	}
	
	public String logout() {
		
		return null;
	}
	
	public String removeUser(String id) {
		
		return null;
	}
	
	public UserHandler() {
		
	}

}
