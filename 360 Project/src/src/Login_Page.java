package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class is the Login_Page GUI. It is the jumping off point for the whole GUI system, with users logging with this page and then
 * being shown a user specific page. Login attempts are checked by communicating with the Login_Database class.
 * 
<<<<<<< HEAD
 * @author Dovi Bergman
 * @since 5/24/2016
=======
 * @author Dovi Bergman, Sukhpreet Jawandha
 * @version Last Modified 5/25/2016
>>>>>>> branch 'master' of https://github.com/Elthias/TeamX
 */
public class Login_Page {
	/**
	 * Width for the frame.
	 */
	private static final int WIDTH = 600;

	/**
	 * Height for the frame.
	 */
	private static final int HEIGHT = 600;

	/**
	 * Login Database to login.
	 */
	private final Login_Database myLogin_Database;
	
	/**
	 * Frame to add panel.
	 */
	private final JFrame myFrame;
	
	/**
	 * Main panel for Login Page with title name.
	 */
	private final JPanel myP;
	
	/**
	 * Panel to cover the space.
	 */
	private final JPanel myP1;
	
	/**
	 * Panel for Account Login and password fields and labels.
	 */
	private final JPanel myP2;
	
	/**
	 * Panel for Login Button.
	 */
	private final JPanel myP3;
	
	/**
	 * Password field for password.
	 */
	private JPasswordField myPassField;
	
	/**
	 * Text field for account number.
	 */
	private final JTextField myIDField;
	
	/**
	 * Integer to login with ID.
	 */
	private int myLoginID;
	
	/**
	 * Password as a string.
	 */
	private String myPass;
	
	
	/**
	 * Constructor of Login page. It initialize all fields and call some methods.
	 */
	public Login_Page() {
		myLoginID = 0;
		myPass = null;
		myFrame = new JFrame();
		setFrame();
		myP = new JPanel();
		myP1 = new JPanel();
		myP2 = new JPanel();
		myP3 = new JPanel();
		myPassField = new JPasswordField();
		myIDField = new JTextField("", 12);
		myPassField = new JPasswordField(12);
		
		myLogin_Database = new Login_Database();
			
		myP.setLayout(new GridLayout(3, 1));
		myP2.setLayout(new FlowLayout(FlowLayout.LEADING));
		myP2.setBackground(Color.YELLOW.darker().darker());
		myP3.setBackground(Color.YELLOW.darker().darker());
		myP1.setBackground(Color.YELLOW.darker().darker());
		myP.add(myP1);
		myP.add(myP2);
		myP.add(myP3);
		myFrame.add(myP);
		namePanel();
		login();
		signIn();
	}

	/**
	 * It sets the frame and positions.
	 */
	private void setFrame() {
		myFrame.requestFocus();
		myFrame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		myFrame.setResizable(false);

	}

	/**
	 * It prints the title on the top of the panel with size and style.
	 */
	private void namePanel() {
		final JLabel title = new JLabel("Clark County Library");
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		myP1.add(title, BorderLayout.NORTH);
	}
	
	/**
	 * creates the login fields and labels applied action listeners.
	 */
	private void login() {
		final JLabel account = new JLabel("               Account Number :");
		account.setFont(new Font("Serif", Font.BOLD, 25));
		account.setForeground(Color.WHITE);
		myP2.add(account);
		
		myIDField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theEvent) {
				myLoginID = Integer.parseInt(myIDField.getText());
			}
		});
		myP2.add(myIDField);

		final JLabel pass = new JLabel("                            Password :");
		pass.setFont(new Font("Serif", Font.BOLD, 25));
		pass.setForeground(Color.WHITE);
		myP2.add(pass);
		
		myPassField.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent theEvent) {
				myPass = myPassField.getText();
			}
		});
		myP2.add(myPassField);
		
	} 

	/**
	 * creates the login button on the bottom of the login page.
	 */
	private void signIn() {
		JButton login = new JButton("Login");
		login.addActionListener(new LoginAction(myLoginID, myPass));
		myP3.add(login);
	}
	
	/**
	 * Class for login actions implementing action listener and applied on button or fields.
	 * Designed for use with the Login_Page login button.
	 * Processes a login attempt by communicating with Login_Page's myLogin_Database field.
	 * If the login is successful, the LoginAction will empty the JTextFields, and open the appropriate
	 * user page on top of the LoginPage JPanel, hiding it from view until that user page closes itself.
	 * @author Dovi Bergman
	 *
	 */
	public class LoginAction implements ActionListener {
		
		/**
		 * Fields for the ID number, Password, Role, and a boolean for whether the login is valid.
		 */
		private int myID;
		private String myPassword;
		private String myRole;
		private boolean myValidLogin;
		
		/**
		 * A constructor for a LoginAction that takes 2 parameters
		 * @param theId = the ID number for looking up a user
		 * @param thePassword = the password that was entered for that user.
		 */
		public LoginAction (int theID, String thePassword) {
			myID = theID;
			myPassword = thePassword;
		}
		
		/**
		 * The action performed by the action.
		 * @param theEvent = the ActionEvent that triggers this action, which chould be a button press of the login button.
		 */
		public void actionPerformed(ActionEvent theEvent) {
			myValidLogin = myLogin_Database.checkLogin(theID, thePassword);
			if (myValidLogin) {
				myRole = myLogin_Database.getRole(theID);
				login (myRole);
			}
			
		}
		
		/**
		 * Logs the user in and displays their login page after resetting the JTextFields for ID and Password.
		 * @param theRole = the role retrieved for this user from the Login_Database. 
		 */
		public boolean login (String theRole) {
			
			myPassField.setText(null);
			myIDField.setText(null);
			
			if (theRole == "judge") {
				Judge_Page jPage = new Judge_Page();
				myFrame.add(jPage.myPanel);
			} else if (theRole == "librarian") {
				Librarian_Page lPage = new Librarian_Page();
				myFrame.add(lPage.myPanel);
			} else if (theRole == "contestant") {
				Contestant_Page cPage = new Contestant_Page();
				myFrame.add(cPage.myPanel);
			}
			
			return myValidLogin;
			
		}
	}
	
}
