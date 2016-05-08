package test;

import model.Easter;

import org.junit.Before;
import org.junit.Test;

public class EasterTest {
	private Easter egg;

	@Before
	public void testSetup() {
		egg = new Easter();
	}
	
	@Test
	public void testMain() {
		String names = egg.getNames();
	}

}
