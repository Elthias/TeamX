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



public class Contestant_Page {
	private JPanel myP;
	private JFrame myFrame;
	private JPanel myP1;
	private JPanel myP2;
	private JPanel myP3;


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


	private void setFrame() {
		myFrame.requestFocus();
		myFrame.setMinimumSize(new Dimension(600, 600));
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		myFrame.setResizable(false);
	}

}

