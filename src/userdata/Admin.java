package userdata;

import java.util.Random;

public class Admin extends User{
	Random rand = new Random();
	
	public Admin() {
		super();
		
	}
	
	public Admin(String id, String email, String password, String name, String type) {
		super(id, email, password, name, type);
		
	}

	@Override
	public String generateId() {
		
		return "AD" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		
	}

}
