/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: mar 26, 2023
 * Modified: mar 25, 2023
 * Description:The WorldClock class extends the Clock class and represents a clock that is set to a specific time zone
 * based on the provided offset. The current time in the specified time zone can be retrieved using the getTime() method.
 *      
 */
package assignment2;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * The WorldClock class extends the Clock class and represents a clock that is set to a specific time zone
 * based on the provided offset. The current time in the specified time zone can be retrieved using the getTime() method.
 */
public class WorldClock extends Clock {
    
    // Instance variable to store the time zone offset
    private int offset;
    
    /**
     * Creates a new WorldClock object with the specified time zone offset.
     * The initial time is set by adding the offset to the current time.
     * 
     * @param offset The time zone offset from UTC in hours (-12 to 12).
     */
    public WorldClock(int offset) {
    	super();
        this.offset = offset;

    }

    /**
     * Returns the time zone offset from UTC in hours.
     * 
     * @return The time zone offset.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * A class representing a world clock that shows the time in a specific time zone 
     * offset from the Universal Time Clock (UTC).
    */
    @Override
    public String getTime() {
    	String time= LocalDateTime.ofInstant(Instant.now(),ZoneId.of("UTC")).toString().substring(11, 13);
    	int calculations =(Integer.parseInt(time) + offset);
  	     if(calculations >= 24) {
	    	 calculations = Math.abs(24 - calculations);
	    	}
	     return String.format("%02d:%02d", calculations,getMinutes());
	     }
}