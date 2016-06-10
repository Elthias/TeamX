
/**
 * This is a JUnit test class for Login_Database. It tests The check login
 * method as the test will cover the other methods as well.
 * @author David Rainey
 * @version 6/6/2015
 */package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class Login_DatabaseTest {
	/**
	 * Tests to make sure that the password check is correct.
	 */

	@Test
	public void testCheckLogin() {
		User test1 = new User("password","Judge");
		Login_Database test2 = new Login_Database();
		test2.addUsers(100, test1);
		String testStringGood = "password";
		String testStringBad = "passw";
		
		assertEquals("The password was not checked by setCat", "Judge", test2.checkLogin(100, testStringGood));
		assertEquals("The password was not checked by setCat", null, test2.checkLogin(100, testStringBad));
	}


}
