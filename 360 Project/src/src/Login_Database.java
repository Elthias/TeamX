package src;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is a Login database that keeps track of users.
 * @author Sarjodh Dhillon
 * @version 05/28/2016
 */
public class Login_Database {
	
	/**
	 * Map field myUser that stores the users.
	 */
	private Map<Integer, User> myUser;
	
	/**
	 * This is a contructor that will initialize the HashMap.
	 */
	public Login_Database() {
		myUser = new HashMap<Integer, User>();
	}
	
	/**
	 * This method checks the login to get the right user
	 * (contestant, librarian or judge).
	 * @param theId is the Id of an user.
	 * @param thePass is the password associated with Id.
	 * @return the role associated with an Id(contestant, librarian or judge).
	 */
	public String checkLogin(int theId, String thePass) {
		User u = myUser.get(theId);
		if(u.getPass().equals(thePass)) {
			return u.getRole(); 
		} else {
			return null;
		}
	}
	
	/**
	 * This method sets the given role to the given ID.
	 * @param theId is the Id to which role needs to be set.
	 * @param theRole is the role(contestant, librarian or judge).
	 */
	public void setRole(int theId, String theRole) {
		User u = myUser.get(theId);
		u.setRole(theRole);
	}
	
	/**
	 * This method adds the users to the Map.
	 * @param theId is the ID of a user.
	 * @param theUser is User that needs to be added.
	 */
	public void addUsers(int theId, User theUser) {
		myUser.put(theId, theUser);
	}
	

}
