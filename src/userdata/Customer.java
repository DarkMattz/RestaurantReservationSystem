package userdata;

import java.util.Random;

public class Customer extends User{
	Random rand = new Random();
	
	public Customer(String id, String email, String password, String name, String type) {
		super(id, email, password, name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generateId() {

		return "CU" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
	}

}
