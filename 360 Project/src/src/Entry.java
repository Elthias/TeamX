package src;

import java.io.File;

public class Entry {
	private int myId;
	private String myName;
	private File myFile;
	private String myCategory;
	private int myScore;
	private String myNotes;

	public Entry(int theId, String theName) {
		myId = theId;
		myName = theName;
	}

	public void setCat(String theCat) {
		myCategory = theCat;
	}
	
	public void setEntry(File theFile) {
		myFile = theFile;
	}
	
	public void setScore(int theScore) {
		myScore = theScore;
	}
	
	public void setNotes(String theNotes) {
		myNotes = theNotes;
	}
	
	public File getFile() {
		return myFile;
	}
	
	public int getScore() {
		return myScore;
	}
	
	public String getNotes() {
		return myNotes;
	}
	
	public String getCat() {
		return myCategory;
	}
	
	public String getName() {
		return myName;
	}
	
	public int getId() {
		return myId;
	}
	
}
