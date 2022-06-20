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
		
		if(!isEmailValid && !isCheckEmailSuccess) {
			
			return "Email is not valid";
		}
		
		if(!isNameValid) {
			
			return "Username is not valid";
		}
		
		if(!isPassValid) {
			
			return "Password is not valid";
		}
		
			
		if(isEmailValid && isNameValid && isPassValid && isCheckEmailSuccess) {
			
			return null;
		}
		
		return "Register data is incorrect !";
	}
	
	public String login(String email, String password) {
		
		boolean isEmailValid = false;
		boolean isPassValid = false;
		
//		validasi email
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
			
			//ngecocokin yg ada di database cocok ga?
			if() {
				
				return "Email not found !";
			}else {
				
				isEmailValid = true;
			}
		}
		
			
//			validasi password
			if(password.isEmpty()) {
				
				return "Input your password !";
			}else {
				
				// ngecocokin yg ada di database cocok ga?
				//checkPassword() nanti return nya false kalo misalkan dia ga sesuai dg yg terdaftar
				if(database.checkPassword()) {
					
					return "Password didn't match !";
				}else {
					
					isPassValid = true;
				}

			}
			
			if(!isEmailValid) {
				
				System.out.println("Email is not valid");
			}
			
			
			if(!isPassValid) {
				
				System.out.println("Password is not valid");
			}
			
				
			if(isEmailValid && isPassValid) {
				
				return null;
			}
			
			return "Login data is incorrect !";
			
		
		return "Login unsuccessful !";
	}
	
	public String logout() {
		
		user = null;
		
		return "User has been logged out";
	}
	
	public String removeUser(String email) {
		
		boolean isEmailValid = false;
		boolean isCheckEmailSuccess = false;
		
		if(email.isEmpty()) {
			
			return "Input your email to Continue !";
		}else {
			
			//ngetest data email di database sesuai apa ngga
			if(database.checkEmail()) {
				
				return "Invalid Email !";
			}else {
				
				isEmailValid = true;
				return null;
			}
			
		}
		
		return "Can't be removed !";
	}
	
	public Userhandler() {
		
	}

}
