package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * This class contains the user page GUI for a Judge. In it they may view and score various entries. Entries are populated
 * in a table to be displayed to the judge.
 * @author Dovi Bergman, Kenneth Patterson
 *
 */
public class Judge_Page {
	/**
	 * Width for the frame.
	 */
	private static final int WIDTH = 600;

	/**
	 * Height for the frame.
	 */
	private static final int HEIGHT = 600;
	
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
	 * Table to display the various entry information.
	 */
	private JTable myEntries;
	
	/**
	 * Data structure to hold information on current entries.
	 */
	private Entry_Database myEntryData;
	
	/**
	 * Button which can be used to logout of the current user.
	 */
	private JButton logoutButton;
	
	/**
	 * Button which may be used to save the data in the table.
	 */
	private JButton saveButton;
		
	/**
	 * The Object array with the data for myEntries.
	 */
	
	private Object[][] myTableModel;
	
	/**
	 * Constructor of Judge page. Loads an entry database to be used in populating the database.
	 * @param theEntryData
	 */
	public Judge_Page(Entry_Database theEntryData) {
		myFrame = new JFrame();
		myP = new JPanel();
		myP1 = new JPanel();
		myP2 = new JPanel();
		myP3 = new JPanel();
		myEntries = new JTable();
		logoutButton = new JButton("Logout");
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int k = 0;
				for (Integer i : myEntryData.keySet()) {
					Entry x = myEntryData.getEntry(i);
					if (myTableModel[k][1].getClass() != Integer.class) {
						x.setScore(Integer.parseInt((String)myTableModel[k][1]));
					}
					x.setNotes((String)myTableModel[k][2]);
					k++;
				}
				myEntryData.writeEntries();
			}
			
		});
		
		myEntryData = theEntryData;
		
		setLayout();
		
		myFrame.add(myP);
		namePanel();
		fillTable();
		myEntries.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = myEntries.getSelectedRow();
					int col = myEntries.getSelectedColumn();
					if (col == 0) {
						for (Integer i: myEntryData.keySet()) {
							Entry a = myEntryData.getEntry(i);
							if (a.getName().equals((String) myEntries.getValueAt(row, col))) {
								Desktop.getDesktop().open(a.getFile());
							}
						}
					}
				} catch (IOException x) {
					System.out.println(x);
				}
			}
		});
		JScrollPane scroll = new JScrollPane(myEntries);
		myP2.add(scroll, BorderLayout.CENTER);
		setFrame();
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myFrame.setVisible(false);
			}
		});
		
	}

	/**
	 * It sets the frame and positions.
	 */
	private void setFrame() {
		myFrame.requestFocus();
		myFrame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.setResizable(false);
		myFrame.pack(); // Added pack to resize frame after adding components
		myFrame.setLocationRelativeTo(null);
	}
	
	/**
	 * Sets the layout to one that is weighted in such a way that the title takes up a minority of the available space
	 * while the table takes up a majority.
	 */
	private void setLayout() {
		myP.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		myP2.setLayout(new BorderLayout());
		// Changed lower background to a lighter yellow
		myP3.setBackground(new Color(255, 255, 77));
		// Changed upper background to a light blue
		myP1.setBackground(new Color(77, 166, 255));
		c.gridwidth = 3;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.4;
		c.fill = GridBagConstraints.BOTH;
		myP.add(myP1, c);
		c.gridy = 1;
		c.gridheight = 3;
		c.weighty = 0.6;
		myP.add(myP2, c);
		c.gridy = 4;
		c.gridheight = 1;
		c.weighty = 0.4;
		myP.add(myP3, c);
		myP3.setLayout(new GridBagLayout());
		c.gridx = 2;
		c.anchor = GridBagConstraints.EAST;
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(0, 10, 0, 10);
		myP3.add(logoutButton, c);
		c.anchor = GridBagConstraints.WEST;
		myP3.add(saveButton, c);
		myP.setVisible(true);
	}
	
	/**
	 * Sets up the titles which the judge may see and inputs them into the table along with their respective data.
	 */
	private void fillTable() {
		String[] titles = {"Entry Name", "Score", "Notes"};
		myTableModel = createData();
		myEntries = new JTable(myTableModel, titles);
	}
	
	/**
	 * Takes data from entries and formats it in a way that the table can accept.
	 * @return the data which is to be input into the table
	 * @throws URISyntaxException 
	 */
	private Object[][] createData() {
		int k = myEntryData.size();
		Object[][] table = new Object[k][3];
		k = 0;
		for (Integer i: myEntryData.keySet()) {
			Entry x = myEntryData.getEntry(i);
			table[k][0] = x.getName();
			table[k][1] = x.getScore();
			table[k][2] = x.getNotes();
			k++;
		}
		return table;
	}

	/**
	 * It prints the title on the top of the panel with size and style.
	 */
	private void namePanel() {
		final JLabel title = new JLabel("Clark County Library");
		title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40)); // Changed to a different font. -KP
		title.setForeground(Color.WHITE);
		myP1.add(title);
	}
	
	public JFrame getFrame() {
		return myFrame;
	}
}