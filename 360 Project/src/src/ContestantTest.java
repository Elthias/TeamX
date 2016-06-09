package src;

import java.io.File;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ContestantTest {
	/**
	 * ID of a contestant.
	 */
	private int myID;
	
	/**
	 * Database of entries.
	 */
	private Entry_Database myEntryData;
	
	@Before
	public void setUp() {
		Random r = new Random();
		myID = r.nextInt();
		for (int i = 0; i < myID % 20; i++) {
			Entry e = new Entry(myID);
			e.setCat("Science");
			e.setEntry(new File("example.txt"));
			e.setName("Test Name");
			e.setNotes("");
			e.setScore(0);
		}
	}

	@Test
	public void testContestant_Page() {
		new Contestant_Page(myID, myEntryData);
		
	}

}
