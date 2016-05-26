package src;

import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class contains the user page GUI for a Librarian 
 * 
 * @author Dovi Bergman, Sukhpreet Singh Jawandha
 */
public class Librarian_Page {
	
	JFrame myFrame;
	
	logout() {
		Button logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ExitAction());
	}
	
}
