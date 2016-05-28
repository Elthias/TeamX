package src;

import java.util.HashMap;
import java.util.Map;

public class Entry_Database {
	private Map<Integer, Entry> myEntry;
	
	public Entry_Database() {
		myEntry = new HashMap<Integer, Entry>();
	}
	
	public Entry getEntry(int theId) {
		return myEntry.get(theId);
	}
	
	public void deleteEntry(int theId) {
		myEntry.remove(theId);
	}
	
	public void addEntry(int theId, Entry theEntry) {
		myEntry.put(theId, theEntry);
	}
	
	public void setCategory(int theId, String theCat) {
		myEntry.get(theCat).setCat(theCat);
	}
}
	
