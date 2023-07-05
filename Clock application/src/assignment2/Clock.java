/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: mar 26, 2023
 * Modified: mar 25, 2023
 * Description:The Clock class represents a clock with hours and minutes.
 *      
 */
package assignment2;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * The Clock class represents a clock with hours and minutes.
 */
public class Clock {
	/**
	 * variables for the hours of the clock
	 */
	private int hours;
	/**
	 * variables for the minutes of the clock
	 */
	private int minutes;

		public Clock() {
			String timeString = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
			this.hours = Integer.parseInt(timeString.substring(11, 13));
			this.minutes = Integer.parseInt(timeString.substring(14, 16));
		}
		/**
		 * Returns the hours of the Clock.
		 * 
		 * @return The hours of the Clock.
		 */
		
	    public int getHours() {
	    	return hours;
	    }
		/**
		 * Returns the minutes of the Clock.
		 * 
		 * @return The minutes of the Clock.
		 */
	    public int getMinutes() {
	    	return minutes;
	    }
		/**
		 * Returns a String representation of the current time on the Clock.
		 * 
		 * @return A String representation of the current time on the Clock.
		 */
	    public String getTime() {
	    	return String.format("%d:%d ",getHours(),getMinutes());
	    }
}
