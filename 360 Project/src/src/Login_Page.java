/**
 * This class is the Login_Page GUI. It is the jumping off point for the whole GUI system, with users logging with this page and then
 * being shown a user specific page. Login attemps are checked by communicating with the Login_Database class.
 * 
 * @author Dovi Bergman, Sukhpreet Jawandha
 * @version Last Modified 5/24/2016
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

	public Login_Page() {
		myFrame = new JFrame();
		setFrame();
		myP = new JPanel();
		myP1 = new JPanel();
		myP2 = new JPanel();
		myP3 = new JPanel();
		
		myLogin_Database = new Login_Database;
			
		myP.setLayout( new GridLayout(3, 1));
		myP2.setLayout( new FlowLayout(FlowLayout.LEADING));
		myP2.setBackground(Color.YELLOW.darker().darker());
		myP3.setBackground(Color.YELLOW.darker().darker());
		myP1.setBackground(Color.YELLOW.darker().darker());
		myP.add(myP1);
		myP.add(myP2);
		myP.add(myP3);
		myFrame.add(myP);
		NamePanel();
		Login();
		SignIn();
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

	private void NamePanel() {
		final JLabel title = new JLabel("Clark County Library");
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		myP1.add(title, BorderLayout.NORTH);
	}

	private void Login() {
		final JLabel account = new JLabel("               Account Number :");
		account.setFont(new Font("Serif", Font.BOLD, 25));
		account.setForeground(Color.WHITE);
		myP2.add(account);
		JTextField number = new JTextField("", 12);
		myP2.add(number);

		final JLabel password = new JLabel("                                                                                                               ");
		myP2.add(password);
		
		final JLabel pass = new JLabel("                            Password :");
		pass.setFont(new Font("Serif", Font.BOLD, 25));
		pass.setForeground(Color.WHITE);
		myP2.add(pass);
		JPasswordField myPass = new JPasswordField(12);
		myP2.add(myPass);
	} 

	private void SignIn() {
		JButton login = new JButton("Login");
		myP3.add(login);
	}
	
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
