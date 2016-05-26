package src;

import javax.swing.JPanel;

/**
 * This class contains the user page GUI for a Librarian 
 * 
 * @author Dovi Bergman, Sukhpreet Singh Jawandha
 */
public class Librarian_Page {
	
	JPanel myPanel;
	
	logout() {
		button logoutButton = new JButton(new ActionListener() {
			
			public void ActionPerformed(ActionEvent theEvent) {
				myPanel.hide();
			}
		});		
	}
	
}
