/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: Jan 26, 2023
 * Modified: Jan 27, 2023
 * Description: This class will create  a report of patient's  record
 * and then will print out the patients results.
 *      
 */
package assignment1;

import java.util.Scanner;
/**
* This is the driver class for this program. This means that it just runs the application with a method
* main.
* @author Seifeldin Eid
*/

public class MyHealthDataTest {
	/**
	 * This class is used to get information about a patient such as first and last name, gender, year , month and day of birth
	 * and height and weight, then it will do some calculations to get the patient BMI, maximum hear rate,
	 * target heart rate range between Min and Max. Then print out the result of the patient.
	 * @author Seifeldin Eid
	 *
	 */

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("enter first name:");
		String fname=keyboard.next();
		
		System.out.println("enter last name:");
		String lname=keyboard.next();
		
		System.out.println("enter gender:");
		String gender=keyboard.next();
		
		System.out.println("enter year:");
		int year=keyboard.nextInt();
		
		System.out.println("enter month:");
		int month =keyboard.nextInt();
		
		System.out.println("enter day:");
		int day = keyboard.nextInt();
		
		System.out.println("enter height:");
		double height = keyboard.nextDouble();
		
		System.out.println("enter weight:");
		double weight = keyboard.nextDouble();
		
		Patient patient = new Patient(fname,lname,gender,year,month,day,height,weight);
		patient.displayMyHealthData();
		
		keyboard.close();
		
	}

}
