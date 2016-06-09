package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
 * @author Dovi Bergman
 * @since 5/24/2016
=======
 * @author Dovi Bergman, Sukhpreet Jawandha, Kenneth Patterson
 * @version Last Modified 5/25/2016
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
	 * Entry Database for the user pages
	 */
	
	private final Entry_Database myEntryDatabase;
	
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
	public Login_Page(Login_Database theLoginData, Entry_Database theEntryData) {
		myLoginID = 0;
		myPass = null;
		myFrame = new JFrame();
		myP = new JPanel();
		myP1 = new JPanel();
		myP2 = new JPanel();
		myP3 = new JPanel(new GridBagLayout());
		myIDField = new JTextField("", 12);
		myPassField = new JPasswordField(12);
		
		myLogin_Database = theLoginData;
		myEntryDatabase = theEntryData;
		
		myP.add(myP1);
		myP.add(myP2);
		myP.add(myP3);
		setLayout();
		namePanel();
		login();
		signIn();
		myFrame.add(myP);
		setFrame();
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
		myFrame.pack();

	}
	
	/**
	 * Adjusts the layout of the login page.
	 */
	private void setLayout() {
		myP.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		myP2.setLayout(new GridBagLayout());
		// Changed upper background to a light blue
		myP1.setBackground(new Color(77, 166, 255));
		// Changed middle background to a dark blue
		myP2.setBackground(new Color(0, 76, 112));
		// Changed lower background to a lighter yellow
		myP3.setBackground(new Color(255, 255, 77));
		c.gridwidth = 3;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.05;
		c.fill = GridBagConstraints.BOTH;
		myP.add(myP1, c);
		c.gridy = 1;
		c.gridheight = 3;
		c.weighty = 1;
		myP.add(myP2, c);
		c.gridy = 4;
		c.gridheight = 1;
		c.weighty = 0.05;
		myP.add(myP3, c);
	}

	/**
	 * It prints the title on the top of the panel with size and style.
	 */
	private void namePanel() {
		final JLabel title = new JLabel("Clark County Library");
		title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		myP1.add(title, BorderLayout.NORTH);
	}
	
	/**
	 * creates the login fields and labels applied action listeners.
	 */
	private void login() {
		final JPanel acctP = new JPanel();
		final JPanel passP = new JPanel();
		final JLabel account = new JLabel("Account Number:");
		acctP.setBackground(new Color(0, 76, 112));
		passP.setBackground(new Color(0, 76, 112));
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		account.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		account.setForeground(Color.WHITE);
		acctP.add(account);
		
		myIDField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theEvent) {
				myLoginID = Integer.parseInt(myIDField.getText());
			}
		});
		c.gridx = 1;
		c.gridwidth = 2;
		acctP.add(myIDField);

		final JLabel pass = new JLabel("Password:");
		pass.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		pass.setForeground(Color.WHITE);
		c.gridwidth = 1;
		c.gridx = 0;
		passP.add(pass);
		
		myPassField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theEvent) {
				myPass = new String(myPassField.getPassword());
			}
		});
		passP.add(myPassField);
		
		myP2.add(acctP, c);
		c.gridy = 2;
		myP2.add(passP, c);
	} 

	/**
	 * creates the login button on the bottom of the login page.
	 */
	private void signIn() {
		JButton login = new JButton("Login");
		GridBagConstraints c = new GridBagConstraints();
		login.addActionListener(new LoginAction(myLoginID, myPass));
		c.gridwidth = 3;
		c.gridx = 1;
		myP3.add(login, c);
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
		//private boolean myValidLogin;
		
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
			myID = Integer.parseInt(myIDField.getText());
			myPassword = new String(myPassField.getPassword());
			myRole = myLogin_Database.checkLogin(myID, myPassword);
			if (myRole != null) {
				login (myRole, myID);
			}
			
		}
		
		/**
		 * Logs the user in and displays their login page after resetting the JTextFields for ID and Password.
		 * @param theRole = the role retrieved for this user from the Login_Database. 
		 * @param theID = the ID number of the user logging in.
		 */
		public void login (String theRole, int theID) {
			
			myPassField.setText(null);
			myIDField.setText(null);
			
			if (theRole == "judge") {
				new Judge_Page(myEntryDatabase);
			} else if (theRole == "librarian") {
				new Librarian_Page(myEntryDatabase);
			} else if (theRole == "contestant") {
				new Contestant_Page(theID, myEntryDatabase);
			}
			
		}
	}
	
}
