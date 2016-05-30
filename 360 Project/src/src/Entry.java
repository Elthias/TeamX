package src;

import java.io.File;

/**
 * This class is an Entry class which keeps track of an Entry 
 * submitted by a User.
 * @author Sarjodh Dhillon
 * @version 05/28/2016
 */
public class Entry {
	
	/**
	 * Integer field myId.
	 */
	private int myId;
	
	/**
	 * String field myName.
	 */
	private String myName;
	
	/**
	 * File field myFile for storing the File for an entry.
	 */
	private File myFile;
	
	/**
	 * String field myCategory for category of entry.
	 */
	private String myCategory;
	
	/**
	 * Integer field myScore for storing score.
	 */
	private int myScore;
	
	/**
	 * String field myNotes for storing notes.
	 */
	private String myNotes;

	/**
	 * This is a constructor which initializes the required fields myId and myName
	 * @param theId is an Id of user.
	 * @param theName is the name of an entry.
	 */
	public Entry(int theId, String theName) {
		myId = theId;
		myName = theName;
	}

	/**
	 * This method sets the category for an entry.
	 * @param theCat is a category.
	 */
	public void setCat(String theCat) {
		myCategory = theCat;
	}
	
	/**
	 * This method sets the File to an entry.
	 * @param theFile is the file submitted by a user.
	 */
	public void setEntry(File theFile) {
		myFile = theFile;
	}
	
	/**
	 * This method sets the score to the entry.
	 * @param theScore is the score.
	 */
	public void setScore(int theScore) {
		myScore = theScore;
	}
	
	/**
	 * This method sets the notes to the entry.
	 * @param theNotes is the notes.
	 */
	public void setNotes(String theNotes) {
		myNotes = theNotes;
	}
	
	/**
	 * This method returns the file that is in the entry.
	 * @return myFile that is file associated with entry.
	 */
	public File getFile() {
		return myFile;
	}
	
	/**
	 * This method will return the scores given to the entry.
	 * @return myScore associated with an entry.
	 */
	public int getScore() {
		return myScore;
	}
	
	/**
	 * This method will return the notes given to the entry.
	 * @return myNotes associated with an entry.
	 */
	public String getNotes() {
		return myNotes;
	}
	
	/**
	 * This method will the return the category of the entry.
	 * @return myCategory associated with an entry.
	 */
	public String getCat() {
		return myCategory;
	}
	
	/**
	 * This methods returns the entry name.
	 * @return myName associated with an entry.
	 */
	public String getName() {
		return myName;
	}
	
	/**
	 * This method returns an ID
	 * @return myId associated with an entry.
	 */
	public int getId() {
		return myId;
	}
	
}
