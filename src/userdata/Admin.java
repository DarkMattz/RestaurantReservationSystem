package userdata;

import java.util.Random;

public class Admin extends User{
	
	Random rand = new Random();
	
	public Admin(String id, String email, String password, String name, String type) {
		super(id, email, password, name, type);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generateId() {
		
		return "AD" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10); 
	}

}
