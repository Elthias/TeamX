package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class is a Entry database which stores the entries submitted by users.
 * @author Sarjodh Dhillon, Ken Patterson
 * @version 05/28/2016
 */
public class Entry_Database {
	
	/**
	 * Field myEntries that will be a Map.
	 */
	private Map<Integer, Entry> myEntries;
	
	/**
	 * This is a constructor which initialize the field.
	 */
	public Entry_Database() {
		myEntries = new HashMap<Integer, Entry>();
	}
	
	/**
	 * This method will extract an entry from the HashMap.
	 * @param theId is an ID of a user we want the entry for.
	 * @return an entry associated with the ID.
	 */
	public Entry getEntry(int theId) {
		return myEntries.get(theId);
	}
	
	/**
	 * This method will delete the entry.
	 * @param theId is an ID of user who wants to delete its entry.
	 */
	public void deleteEntry(int theId) {
		myEntries.remove(theId);
	}
	
	/**
	 * This method will add a new entry to the HashMap.
	 * @param theId is an ID of a user who wants to add an entry.
	 * @param theEntry is an entry that needs to be added.
	 */
	public void addEntry(int theId, Entry theEntry) {
		myEntries.put(theId, theEntry);
	}
	
	/**
	 * This method will set the category of an entry.
	 * @param theId is an ID of user
	 * @param theCat is the category assigned to the user.
	 */
	public void setCategory(int theId, String theCat) {
		myEntries.get(theId).setCat(theCat);
	}
	
	/**
	 * This method returns a reference to all of the entries' keys in order to more easily obtain entries.
	 * @return the set of all keys to reference the entries
	 */
	public Set<Integer> keySet() {
		return myEntries.keySet();
	}
	
	/**
	 * This method returns the number of entries contained in the set of keys to the data structure.
	 * @return the number of entries
	 */
	public int size() {
		return myEntries.keySet().size();
	}
}
	
