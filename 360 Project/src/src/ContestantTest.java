package src;

import java.io.File;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
/**
 * Class used for testing the Contestant_Page GUI class.
 * @author Kenneth Patterson
 * @version 6/8/2016
 */
public class ContestantTest {
	/**
	 * ID of a contestant.
	 */
	private int myID;
	
	/**
	 * Database of entries.
	 */
	private Entry_Database myEntryData;
	
	/**
	 * Initializes an ID and a set of entries
	 */
	@Before
	public void setUp() {
		Random r = new Random();
		myID = r.nextInt();
		for (int i = 0; i < 20; i++) {
			Entry e = new Entry(myID);
			e.setCat("Science");
			e.setEntry(new File("example.txt"));
			e.setName("Test Name");
			e.setNotes("");
			e.setScore(0);
		}
	}

	/**
	 * Tests that a contestant page may be created.
	 */
	@Test
	public void testContestant_Page() {
		new Contestant_Page(myID, myEntryData);
		
	}

}
