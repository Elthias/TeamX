
package src;

import java.awt.EventQueue;

public class Main {

	
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
                new Contestant_Page();
                new Login_Page();
            }
        });
    }
}


