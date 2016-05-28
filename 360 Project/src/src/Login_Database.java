package src;

import java.util.HashMap;
import java.util.Map;

public class Login_Database {
	private Map<Integer, User> myUsers;
	
	public Login_Database() {
		myUsers = new HashMap<Integer, User>();
	}
	
	public String checkLogin(int theId, String thePass) {
		User u = myUsers.get(theId);
		if(u.getPass().equals(thePass)) {
			return u.getRole(); 
		} else {
			return null;
		}
	}
	
	public void setRole(int theId, String theRole) {
		User u = myUsers.get(theId);
		u.setRole(theRole);
	}
	
	public void addUsers(int theId, User theUser) {
		myUsers.put(theId, theUser);
	}
}
