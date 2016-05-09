/*
 * Team X Easter Egg Class
 */
package model;

/**
 * Simple class that outputs the name of each member of our team along with a simple message.
 * 
 * @author Kenneth Patterson
 * @author Dovi Bergman
 * 
 */
public class Easter {
	/** String to hold the names of our team members. */
	private String names;
	
	/**
	 * Constructor which initializes the fields to the desired message.
	 */
	public Easter() {
		names = "We are Team X! Form up!\n";
		names += "Ken Patterson: 'Tigertron!'\n";
		names += "Dovi Bergman\n";
		// Insert subsequent lines here.
	}
	
	/**
	 * Method to obtain the names of the team members.
	 * 
	 * @return the string containing our separate messages and names
	 */
	public String getNames() {
		return names;
	}
}
