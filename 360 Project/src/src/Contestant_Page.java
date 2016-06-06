package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
	 * field with the userID for this instance of the page
	 */
	
	/**
	 * field to keep track of entry.
	 */
	private final Entry myEntry;

	/**
	 * field for entry database.
	 */
	private Entry_Database myEntryData;

	/**
	 * Frame to add panel.
	 */
	private final JFrame myFrame;

	/**
	 * Main panel for Login Page with title name.
	 */
	private final JPanel myP;

	/**
	 * Panel for the buttons and fields.
	 */
	private final JPanel myP1;

	/**
	 * The ID of this contestant, used as a key for the new Entry in the Entry database.
	 */
	private int myID;

	/**
	 * Constructor of Contestant page. It initializes all fields and calls some methods with layout.
	 * @param the ID number of the user who opened this page
	 */
	public Contestant_Page(int theUserID, Entry_Database theEntryData) {
		myID = theUserID;
		myEntry = new Entry(myID);
		myEntryData = theEntryData;
		myFrame = new JFrame();
		myP = new JPanel();
		myP.setBackground(Color.YELLOW.darker().darker());
		myP1 = new JPanel();
		myP1.setLayout(new GridLayout(10,10,100,25));
		myP1.setBackground(Color.YELLOW.darker().darker());
		myP1.setPreferredSize( new Dimension(200, 600));
		myP.add(myP1);
		myFrame.add(myP);
		SetFrame();
		Entry();

	}

	/**
	 * It prints the title on the top of the panel with size and style.
	 *//*
	private void namePanel() {
		final JLabel title = new JLabel("Clark County Library");
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		myP1.add(title, BorderLayout.NORTH);
	}*/
	
	/**
	 * This function creates the buttons, label and fields to submit the entry and adds to the main panel.
	 */
	private void Entry() {
		final JLabel entryName = new JLabel("Entry Name :" );
		entryName.setFont(new Font("Serif", Font.BOLD, 20));
		entryName.setForeground(Color.WHITE);

		myP1.add(entryName);
		final JTextField name = new JTextField("", 12);
		name.setLocation(10, 10);
		name.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myEntry.setName(name.getText());
			}
		});
		myP1.add(name);

		final JLabel cate = new JLabel("Categories:");
		cate.setFont(new Font("Serif", Font.BOLD, 20));
		cate.setForeground(Color.WHITE);
		myP1.add(cate);

		String[] cat = {"Science", "US History", "Politics", "Sci-fi", "Romance"};
		final JComboBox<?> myCombo = new JComboBox<Object>(cat);
		myCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myEntry.setCat((String)myCombo.getSelectedItem());
			}			
		});		
		myP1.add(myCombo);

		final JButton delete = new JButton("Delete Entry");
		myP1.add(delete);
		delete.setVisible(false);

		JButton logout = new JButton("Logout");
		//logout.addActionListener(new ExitAction());
		
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myFrame.setVisible(false);
			}
		});
		
		myP1.add(logout);
		final JButton chooseFile = new JButton("Choose a file...");
		myP1.add(chooseFile);

		final JButton submit = new JButton("Submit");
		chooseFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				JFileChooser fileChoose=new JFileChooser();
         		fileChoose.showOpenDialog(myFrame);
				submit.setEnabled(true);
				submit.setVisible(true);
				File file  = fileChoose.getSelectedFile();
				myEntry.setEntry(file);
			}
		});
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myEntryData.deleteEntry(myID);
				delete.setVisible(false);
				submit.setVisible(true);
				cate.setVisible(true);
				chooseFile.setVisible(true);
				myCombo.setVisible(true);
				name.setEditable(true);
			}
		});
		submit.setEnabled(false);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myEntry.setCat((String)myCombo.getSelectedItem());
				myEntry.setName(name.getText());
				myEntryData.addEntry(myID, myEntry);
				delete.setEnabled(true);
				delete.setVisible(true);
				chooseFile.setVisible(false);
				submit.setVisible(false);
				cate.setVisible(false);
				myCombo.setVisible(false);
				name.setEditable(false);
			}
		});
		myP1.add(submit);

	}

	/**
	 * It sets the frame and positions.
	 */
	private void SetFrame() {
		myFrame.requestFocus();
		myFrame.setMinimumSize(new Dimension(600, 600));
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		myFrame.setResizable(false);
	}

}
