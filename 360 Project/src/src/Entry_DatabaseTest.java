/**
 * This is a JUnit test class for Entry_Database. It tests the only slightly complex method, setCat.
 * @author Dovi Bergman
 * @version 6/6/2015
 */
package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class Entry_DatabaseTest {

	/**
	 * A test for setCat method. set the category of an Entry and sees if the result was achieved.
	 */
	@Test
	public void setCatTest() {
		Entry_Database db = new Entry_Database();
		db.addEntry(1, new Entry(1));
		db.setCategory(1, "cat");
		assertEquals("The category was not set by setCat", "cat", db.getEntry(1).getCat());
	}

}
