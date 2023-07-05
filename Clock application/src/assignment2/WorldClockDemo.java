/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: mar 26, 2023
 * Modified: mar 25, 2023
 * Description:The WorldClockDemo class tests the WorldClock class by creating a new WorldClock instance and
 * printing out the hours, minutes, and time with a given offset.
 *      
 */
package assignment2;

/**
* The WorldClockDemo class tests the WorldClock class by creating a new WorldClock instance and
* printing out the hours, minutes, and time with a given offset.
*/
public class WorldClockDemo {

/**
The main method creates a new WorldClock instance with a given offset and prints out the
hours, minutes, and time.
@param args the command line arguments
*/
public static void main(String[] args) {
// Test WorldClock
System.out.println("");
System.out.println("Testing WorldClock class");
int offset =1;
System.out.println("Offset: " + offset);
WorldClock wclock = new WorldClock(offset);
System.out.println("Hours: " + wclock.getHours());
System.out.println("Minutes: " + wclock.getMinutes());
System.out.println("Time: " + wclock.getTime());
}
}
