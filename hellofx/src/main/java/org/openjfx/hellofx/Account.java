package org.openjfx.hellofx;

public class Account {
	
	private String username;
	private String password1;
	private String password2;
	
	public Account(String username, String password1, String password2) {
		this.username = username;
		this.password1 = password1;
		this.password2 = password2;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword1() {
		return password1;
	}
	
	public String getPassword2() {
		return password2;
	}
	
	public boolean checkPasswords() {
		if (password1.equals(password2))
			return true;
		else
			return false;
	}

}