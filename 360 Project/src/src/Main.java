
package src;

import java.awt.EventQueue;

public class Main {

	/**
	 * The login data base
	 */
	private static Login_Database myLoginData;
	/**
	 * The entry database
	 */
	private static Entry_Database myEntryData;

	/**
	 * This class is a driver for the library contest app.
	 * It also deals with creating and updating the databases.
	 * @author David Rainey
	 * @version 06/09/2016
	 */
	private Main() {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the GUI.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	initializeDatabases();
                //new Contestant_Page();
                new Login_Page(myLoginData,myEntryData);
            }
        });
    }
    
    public static void initializeDatabases(){

    	myLoginData = new Login_Database();

    	int id = 1;

    	myLoginData.addUsers(id++, new User("1234","librarian"));
    	myLoginData.addUsers(id++, new User("1234","judge"));
    	for(int i = 0; i < 100; i++){
    		myLoginData.addUsers(id++, new User("1234","contestant"));
    	}
    	System.out.print(myLoginData);
    	myEntryData = new Entry_Database();
    }
}










