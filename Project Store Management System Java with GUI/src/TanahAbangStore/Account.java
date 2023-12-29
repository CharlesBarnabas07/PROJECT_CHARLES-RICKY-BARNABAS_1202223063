package TanahAbangStore;

import java.util.ArrayList;

public abstract class Account {
	
	private String name;
	private long phonenumber;
	private String email;
	private String password;
	
	public Account() {
		
	}
	
	public Account(String name, long phonenumber, String email, String password) {
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
	}
	abstract void menu(ArrayList<Account> accounts, ArrayList<Item> menu);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
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

}
