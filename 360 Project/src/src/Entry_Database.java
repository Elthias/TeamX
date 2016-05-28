package src;

import java.util.HashMap;
import java.util.Map;

public class Entry_Database {
	private Map<Integer, Entry> myEntries;
	
	public Entry_Database() {
		myEntries = new HashMap<Integer, Entry>();
	}
	
	public Entry getEntry(int theId) {
		return myEntries.get(theId);
	}
	
	public void deleteEntry(int theId) {
		myEntries.remove(theId);
	}
	
	public void addEntry(int theId, Entry theEntry) {
		myEntries.put(theId, theEntry);
	}
	
	public void setCategory(int theId, String theCat) {
		myEntries.get(theCat).setCat(theCat);
	}
}
	
