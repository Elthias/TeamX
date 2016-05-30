package src;

/**
 * This class is the User class which could be either contestant, 
 * librarian or judge. 
 * @author Sarjodh Dhillon
 * @version 05/28/2016
 */
public class User {

	/**
	 * String field myPass which is a password.
	 */
	private String myPass;
	
	/**
	 * String field myRole which is a role of an user.
	 */
	private String myRole;

	/**
	 * this is a constructor that initializes the fields
	 * @param thePass is the password.
	 * @param theRole is the role.
	 */
	public User(String thePass, String theRole) {
		myPass = thePass;
		myRole = theRole;
	}

	/**
	 * This is a getter method for myPass field.
	 * @return myPass. 
	 */
	public String getPass() {
		return myPass;
	}
	
	/**
	 * This is a getter method for myRole field.
	 * @return myRole.
	 */
	public String getRole() {
		return myRole;
	}

	/**
	 * This is a setter method for myRole if it needs to changed later.
	 * @param theRole is a role that needs to be given to the user.
	 */
	public void setRole(String theRole) {
		myRole = theRole;
	}
	
	/**
	 * This is a setter method for myPass if the password needs to changed later.
	 * @param thePass is the passwords that needs to be changed to.
	 */
	public void setPass(String thePass) {
		myPass = thePass;
	}
	
}