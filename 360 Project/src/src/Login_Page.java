/**
 * This class is the Login_Page GUI. It is the jumping off point for the whole GUI system, with users logging with this page and then
 * being shown a user specific page. Login attemps are checked by communicating with the Login_Database class.
 * 
 * @author Dovi Bergman
 * @version Last Modified 5/24/2016
 */
public class Login_Page {
	
	myLogin_Database = new Login_Database;
	
	
	public class Login_Action(int theID, String thePassword) implements Action_Listener {
		public void actionPerformed(ActionEvent theEvent) {
			String role;
			boolean validLogin = myLogin_Database.checkLogin(theID, thePassword);
			if (validLogin) {
				role = myLogin_Database.getRole(theID);
			}
			
			// todo: close the current panel
			
			if (role == "judge") {
				// open a judge page panel
			} else if (role == "librarian") {
				// open a librarian panel
			} else if (role == "contestant") {
				// open a contestant panel
			}
			
			
		}
	}
	
}
