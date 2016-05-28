package src;

public class User {

	private String myPass;
	private String myRole;

	public User(String thePass, String theRole) {
		myPass = thePass;
		myRole = theRole;
	}

	public String getPass() {
		return myPass;
	}
	
	public String getRole() {
		return myRole;
	}

	public void setRole(String theRole) {
		myRole = theRole;
	}
	
	public void setPass(String thePass) {
		myPass = thePass;
	}
	
}