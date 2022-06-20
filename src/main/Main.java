package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import userdata.Userhandler;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		
		
	}

	public static void main(String[] args) {
		
		String email = "nadzla@gmail.com";
		String name = "nadzla";
		String pass = "nadzlaandrita12345678";
		
//		String regexEmail = "^(.+)@(\\S+)$";
//		Pattern pattern = Pattern.compile(regexEmail);
//		Matcher matcher = pattern.matcher(email);
//
//		System.out.println("Email : " + matcher.matches());
		
		Userhandler user = new Userhandler();
		
		System.out.println(user.register(email, name, pass));
	}

}
