/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: mar 26, 2023
 * Modified: mar 25, 2023
 * Description:The AlarmClock class extends the Clock class and represents a clock with an 
 * alarm that can be set to a specific time. The alarm time can be retrieved and 
 * set using the getAlarmhours(), setAlarmhours(), getAlarmminutes(), and 
 * setAlarmminutes() methods, and the current time and alarm status can be 
 * retrieved using the getTime() method.
 *      
 */
package assignment2;
/**
 * The AlarmClock class extends the Clock class and represents a clock with an 
 * alarm that can be set to a specific time. The alarm time can be retrieved and 
 * set using the getAlarmhours(), setAlarmhours(), getAlarmminutes(), and 
 * setAlarmminutes() methods, and the current time and alarm status can be 
 * retrieved using the getTime() method.
 */
import java.time.LocalTime;

public class AlarmClock extends Clock{
	
	// Instance variables to store the alarm time in hours and minutes
	private int alarmhours;
	private int alarmminutes;
	
	/**
	 * Creates a new AlarmClock object with the specified alarm hour and minute.
	 * 
	 * @param alhour The hour at which the alarm should go off (0-23).
	 * 
	 * @param alminute The minute at which the alarm should go off (0-59).
	 */
	public AlarmClock(int alhour, int alminute) {
		super();
		this.alarmhours = alhour;
		this.alarmminutes = alminute;
	}
	
	/**
	 * Returns the hour at which the alarm is set to go off.
	 * 
	 * @return The alarm hour.
	 */
	public int getAlarmhours() {
		return alarmhours;
	}

	/**
	 * Sets the hour at which the alarm should go off.
	 * 
	 * @param alarmhours The alarm hour to set (0-23).
	 */
	public void setAlarmhours(int alarmhours) {
		this.alarmhours = alarmhours;
	}

	/**
	 * Returns the minute at which the alarm is set to go off.
	 * 
	 * @return The alarm minute.
	 */
	public int getAlarmminutes() {
		return alarmminutes;
	}

	/**
	 * Sets the minute at which the alarm should go off.
	 * 
	 * @param alarmminutes The alarm minute to set (0-59).
	 */
	public void setAlarmminutes(int alarmminutes) {
		this.alarmminutes = alarmminutes;
	}
	
	/**
	 * Returns the current time and alarm status as a formatted string.
	 * 
	 * @return The current time and alarm status as a string.
	 */
	public String getTime() {
		if (alarmhours >= 0 && alarmminutes >= 0) {
		// Get the alarm time and current time as LocalTime objects
		LocalTime alarmtime = LocalTime.of(getAlarmhours(),getAlarmminutes());
		LocalTime nowtime = LocalTime.of(getHours(),getMinutes());
		
		// Check if the current time is after or equal to the alarm time
		if(nowtime.isAfter(alarmtime) || nowtime.equals(alarmtime)) {
			ResetAlarm();
			return String.format("%s%s",super.getTime() , " alarm") ;
			
		}else {
			return super.getTime();
		}}
		else {
			return super.getTime();
		}
		}
	
	/**
	 * Resets the alarm by setting the alarm hours and minutes to -1.
	 * 
	 * @return a string message indicating that the alarm has been reset.
	 */
	public String ResetAlarm() {
		setAlarmhours(-1);
		setAlarmminutes(-1);
		return String.format("%s","Alarm has been reset");
	}
}

