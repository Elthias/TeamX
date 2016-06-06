package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class Entry_DatabaseTest {

	@Test
	public void setCatTest() {
		Entry_Database db = new Entry_Database();
		db.addEntry(1, new Entry(1));
		db.setCategory(1, "cat");
		assertEquals("The category was not set by setCat", "cat", db.getEntry(1).getCat());
	}

}
