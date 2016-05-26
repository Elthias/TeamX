package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is the Contestant_Page to submit the entry. It is also GUI with action listeners. It perform
 * all the actions User submit the entry by communicating with the Entry_database class.
 * 
<<<<<<< HEAD
 * @author Sukhpreet Jawandha
 * @since 5/24/2016
=======
 * @author Dovi Bergman, Sukhpreet Jawandha
 * @version Last Modified 5/25/2016
>>>>>>> branch 'master' of https://github.com/Elthias/TeamX
 */


public class Contestant_Page {
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
	 * Constructor of Contestant page. It initialize all fields and call some methods with layout.
	 */
	public Contestant_Page() {
		myFrame = new JFrame();
		myP = new JPanel();
		myP.setBackground(Color.YELLOW.darker().darker());
		myP1 = new JPanel();
		myP1.setLayout(new GridLayout(10,10,100,25));
		myP1.setBackground(Color.YELLOW.darker().darker());
		myP1.setPreferredSize( new Dimension(200, 600));
		myP2 = new JPanel();
		myP2.setPreferredSize(new Dimension(300, 525));
		myP2.setBackground(Color.WHITE);
		myP2.setBorder(BorderFactory.createLineBorder(Color.black));
		myP3 = new JPanel();
		myP3.setBackground(Color.YELLOW.darker().darker());
		myP.add(myP1);
		myP.add(myP2);
		myP1.add(myP3);

		myFrame.add(myP);

		setFrame();
		entry();
	}

	/**
	 * This function creates the buttons, label and fields to submit the entry and adds to the main panel.
	 */
	private void entry() {
		final JLabel entryName = new JLabel("Entry Name :" );
		entryName.setFont(new Font("Serif", Font.BOLD, 20));
		entryName.setForeground(Color.WHITE);

		myP1.add(entryName);
		JTextField name = new JTextField("", 12);
		name.setLocation(10, 10);
		myP1.add(name);

		final JLabel cate = new JLabel("Categories:");
		cate.setFont(new Font("Serif", Font.BOLD, 20));
		cate.setForeground(Color.WHITE);
		myP1.add(cate);

		String[] cat = { "Science", "US History", "Politics", "Sci-fi", "Romance"};
		JComboBox<?> myCombo = new JComboBox<Object>(cat);
		myP1.add(myCombo);

		JButton chooseFile = new JButton("Choose a file...");
		myP1.add(chooseFile);


		JButton submit = new JButton("Submit");
		submit.setEnabled(false);
		myP1.add(submit);

		JButton delete = new JButton("Delete");
		myP1.add(delete);
		delete.setVisible(false);
	}

	/**
	 * It sets the frame and positions.
	 */
	private void setFrame() {
		myFrame.requestFocus();
		myFrame.setMinimumSize(new Dimension(600, 600));
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		myFrame.setResizable(false);
	}

}
