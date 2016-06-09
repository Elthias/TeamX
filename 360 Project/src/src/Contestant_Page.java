package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
 * @author Sukhpreet Jawandha
 * @since 5/24/2016
=======
 * @author Dovi Bergman, Sukhpreet Jawandha, Kenneth Patterson
 * @version Last Modified 5/25/2016
 */


public class Contestant_Page {
	
	/**
	 * field to keep track of entry.
	 */
	private Entry myEntry;

	/**
	 * field for entry database.
	 */
	private Entry_Database myEntryData;

	/**
	 * Frame to add panel.
	 */
	private final JFrame myFrame;

	/**
	 * Main panel for Costestant Page with title, fields, and buttons.
	 */
	private final JPanel myP;
	
	/**
	 * Panel for title.
	 */
	private final JPanel myP1;

	/**
	 * Panel for the buttons and fields.
	 */
	private final JPanel myP2;
	
	/**
	 * Panel for Logout Button.
	 */
	private final JPanel myP3;

	/**
	 * The ID of this contestant, used as a key for the new Entry in the Entry database.
	 */
	private int myID;
	
	/**
	 * Button which can be used to logout of the current user.
	 */
	private JButton logoutButton;

	/**
	 * Constructor of Contestant page. It initializes all fields and calls some methods with layout.
	 * @param the ID number of the user who opened this page
	 */
	public Contestant_Page(int theUserID, Entry_Database theEntryData) {
		myID = theUserID;
		myEntry = theEntryData.getEntry(myID);
		if (theEntryData.getEntry(myID) == null) {
			myEntry = new Entry(myID);
		}
		myEntryData = theEntryData;
		myFrame = new JFrame();
		myP = new JPanel();
		myP1 = new JPanel();
		myP2 = new JPanel(new GridBagLayout());
		myP3 = new JPanel(new GridBagLayout());
		logoutButton = new JButton("Logout");
		
		myP.setBackground(new Color(0, 76, 112));
		//myP2.setLayout(new GridLayout(10,10,100,25));
		

		// Changed lower background to a lighter yellow
		//myP2.setBackground(new Color(255, 255, 77));
		//myP3.setBackground(new Color(255, 255, 77));
		// Changed upper background to a light blue
		//myP2.setPreferredSize( new Dimension(200, 100));
		setLayout();
		namePanel();
		Entry();
		myFrame.add(myP);
		SetFrame();

	}
	
	/**
	 * Sets the layout to one that is weighted in such a way that the title takes up a minority of the available space
	 * while the buttons and text fields take up a majority.
	 */
	private void setLayout() {
		myP.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
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
		c.anchor = GridBagConstraints.NORTH;
		myP.add(myP1, c);
		c.gridy = 1;
		c.gridheight = 3;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		myP.add(myP2, c);
		c.gridy = 5;
		c.gridheight = 1;
		c.weighty = 0.05;
		c.anchor = GridBagConstraints.SOUTH;
		myP.add(myP3, c);
		myP3.setLayout(new GridBagLayout());
		c.gridx = 2;
		c.anchor = GridBagConstraints.EAST;
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(0, 10, 0, 10);
		myP3.add(logoutButton, c);
		myP.setVisible(true);
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
	 * This function creates the buttons, label and fields to submit the entry and adds to the main panel.
	 */
	private void Entry() {
		final JLabel entryName = new JLabel("Entry Name:");
		GridBagConstraints c = new GridBagConstraints();
		entryName.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		entryName.setForeground(Color.WHITE);
		
		c.weightx = 1;
		c.weighty = 0.5;
		myP2.add(entryName, c);
		final JTextField name = new JTextField("", 12);
		name.setLocation(10, 10);
		name.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myEntry.setName(name.getText());
			}
		});
		myP2.add(name, c);

		final JLabel cate = new JLabel("Categories:");
		cate.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		cate.setForeground(Color.WHITE);
		c.gridy = 1;
		myP2.add(cate, c);

		String[] cat = {"Science", "US History", "Politics", "Sci-fi", "Romance"};
		final JComboBox<?> myCombo = new JComboBox<Object>(cat);
		myCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myEntry.setCat((String)myCombo.getSelectedItem());
			}			
		});	
		myP2.add(myCombo, c);

		final JButton delete = new JButton("Delete Entry");
		c.gridy = 3;
		myP2.add(delete, c);
		delete.setVisible(false);
		
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myFrame.setVisible(false);
			}
		});
		
		final JButton chooseFile = new JButton("Choose a file...");
		myP2.add(chooseFile, c);

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
				chooseFile.setVisible(true);
				submit.setVisible(true);
				//cate.setVisible(true);
				//myCombo.setVisible(true);
				//cate.setEnabled(true);
				myCombo.setEnabled(true);
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
				//cate.setVisible(false);
				//myCombo.setVisible(false);
				//cate.setEnabled(false);
				myCombo.setEnabled(false);
				name.setEditable(false);
			}
		});
		myP2.add(submit, c);
		if (myEntryData.getEntry(myID) != null) {
			delete.setEnabled(true);
			delete.setVisible(true);
			chooseFile.setVisible(false);
			submit.setVisible(false);
			//cate.setVisible(false);
			//myCombo.setVisible(false);
			//cate.setEnabled(false);
			myCombo.setEnabled(false);
			name.setEditable(false);
			myCombo.setSelectedItem((Object)myEntry.getCat());
			name.setText(myEntry.getName());
		}
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
		myFrame.pack();
	}

}
