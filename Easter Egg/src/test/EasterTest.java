/*
 * Team X Easter Egg Test
 */

package test;

import model.Easter;

import org.junit.Before;
import org.junit.Test;

public class EasterTest {
	private Easter egg;

	/**
	 * Initializes the Easter class.
	 */
	@Before
	public void testSetup() {
		egg = new Easter();
	}
	
	/**
	 * Tests the getNames method in the Easter class.
	 */
	@Test
	public void testMain() {
		String names = egg.getNames();
	}

}
