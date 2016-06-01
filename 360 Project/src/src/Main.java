
package src;

import java.awt.EventQueue;

public class Main {


	private static Login_Database myLoginData;

	private static Entry_Database myEntryData;

	
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
    	for (int j = 0; j < 100; j++) {
//    		Entry e = new Entry(j, );
    	}
    }
}










