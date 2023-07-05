/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: mar 26, 2023
 * Modified: mar 25, 2023
 * Description:The ClockDemo class tests the functionality of the Clock class.
 *      
 */
package assignment2;

	/**
	 * The ClockDemo class tests the functionality of the Clock class.
	 */
	public class ClockDemo {

	    /**
	     * The main method creates a Clock object and tests the functionality of the Clock class.
	     * 
	     * @param args Command-line arguments (not used).
	     */
	    public static void main(String[] args) {
	        // Create a Clock object
	        Clock clock = new Clock();
	        
	        // Test the Clock class
	        System.out.println("Testing Clock class");
	        System.out.println("Hours: " + clock.getHours());
	        System.out.println("Minutes: " + clock.getMinutes());
	        System.out.println("Time: " + clock.getTime());
	    }
	}

