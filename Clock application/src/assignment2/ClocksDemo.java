/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: mar 26, 2023
 * Modified: mar 25, 2023
 * Description:The ClocksDemo class provides a main method that creates and uses 
 * instances of the Clock, WorldClock, and AlarmClock classes to display 
 * the current time or set an alarm time.
 *      
 */
package assignment2;


/**
 * The ClocksDemo class provides a main method that creates and uses 
 * instances of the Clock, WorldClock, and AlarmClock classes to display 
 * the current time or set an alarm time.
 */
public class ClocksDemo {
	
	/**
	 * The main method creates instances of the Clock, WorldClock, and 
	 * AlarmClock classes, and displays the current time or alarm time for 
	 * each clock object.
	 * 
	 * @param args The command-line arguments passed to the program.
	 */
	public static void main(String[] args)
	{
		// Create an array of Clock objects
		Clock clck[]=new Clock[3];
		
		// Create a regular Clock object
		clck[0] = new Clock();
		
		// Create a WorldClock object with an offset of 2 hours
		clck[1] = new WorldClock(2);
		
		// Create an AlarmClock object set to 7:20 PM
	    clck[2] = new AlarmClock(01,03);
	    
	    /**
	    Loops through the array of Clock objects and prints the classs name and time
	    for each clock.
	    @param clck the array of Clock objects to loop through
	    */
	    for (int i = 0 ; i < clck.length ; i++) {
	        String className = clck[i].getClass().getSimpleName();
	        System.out.println(className + " time: " + clck[i].getTime());
	    }
	    }
		
}

