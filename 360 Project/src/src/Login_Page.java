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
 * being shown a user specific page. Login attemps are checked by communicating with the Login_Database class.
 * 
<<<<<<< HEAD
 * @author Dovi Bergman
 * @since 5/24/2016
=======
 * @author Dovi Bergman, Sukhpreet Jawandha
 * @version Last Modified 5/24/2016
>>>>>>> branch 'master' of https://github.com/Elthias/TeamX
 */
public class Login_Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Width for the frame.
	 */
	private static final int WIDTH = 600;

	/**
	 * Height for the frame.
	 */
	private static final int HEIGHT = 600;

	private final Login_Database myLogin_Database;

	private final JFrame myFrame;
	private final JPanel myP;
	private final JPanel myP1;
	private final JPanel myP2;
	private final JPanel myP3;
	private final JPasswordField myPassField;
	private final JTextField myIDField;
	
	private int myLoginID;
	private String myPass;

	public Login_Page() {
		myLoginID = 0;
		myPass = null;
		
		myFrame = new JFrame();
		setFrame();
		myP = new JPanel();
		myP1 = new JPanel();
		myP2 = new JPanel();
		myP3 = new JPanel();
		
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

	private void namePanel() {
		final JLabel title = new JLabel("Clark County Library");
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		myP1.add(title, BorderLayout.NORTH);
	}

	private void login() {
		final JLabel account = new JLabel("               Account Number :");
		account.setFont(new Font("Serif", Font.BOLD, 25));
		account.setForeground(Color.WHITE);
		myP2.add(account);
		myIDField = new JTextField("", 12);
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
		myPassField = new JPasswordField(12);
		myPassField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theEvent) {
				myPass = myPassField.getText();
			}
		});
		myP2.add(myPassField);
		
	} 

	private void signIn() {
		JButton login = new JButton("Login");
		login.addActionListener(new LoginAction(myLoginID, myPass));
		myP3.add(login);
	}
	
	
	public class LoginAction implements ActionListener {
		
		private int myID;
		private String myPassword;
		private String myRole;
		private boolean myValidLogin;
		
		public int getMyID() {
			return myID;
		}
		
		public String getMyPassword() {
			return myPassword;
		}
		
		public String getMyRole() {
			return myRole;
		}
		
		public boolean isMyValidLogin() {
			return myValidLogin;
		}
		
		public LoginAction (int theID, String thePassword) {
			myID = theID;
			myPassword = thePassword;
		}
		
		public void actionPerformed(ActionEvent theEvent) {
			myValidLogin = myLogin_Database.checkLogin(theID, thePassword);
			if (myValidLogin) {
				myRole = myLogin_Database.getRole(theID);
			}
			login (myRole);
		}
		
		public boolean login (String theRole) {
			
			myPassField.setText(null);
			myIDField.setText(null);
			//reset the text fields
			
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
			
		}
	}
	
}
