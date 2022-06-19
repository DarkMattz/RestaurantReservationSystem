package userdata;

public abstract class User {
	private String id;
	private String email;
	private String password;
	private String name;
	private String type;
	
	public abstract void generateId();
	
	public User(String id, String email, String password, String name, String type) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User() {
		
	}

}
