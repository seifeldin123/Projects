/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: apr 2, 2023
 * Modified: mar 30th, 2023
 * about: The HourlyProgrammer class represents an hourly programmer and extends the Programmer class.
 * It contains a wage and hours worked for a week.
 */
package lab6;

/**
 * The HourlyProgrammer class represents an hourly programmer and extends the Programmer class.
 * It contains a wage and hours worked for a week.
 * @author Seifeldin Eid
 *
 */

public class HourlyProgrammer extends Programmer {
/**
 * The wage per hour for this hourly programmer.
*/
private double wage; 
/**
 * The number of hours worked for a week for this hourly programmer.
 */
private double hours; 
/**
 * Constructs an HourlyProgrammer object with the given first name, last name, social security number, wage and hours worked.
 * @param firstName the first name of this hourly programmer
 * @param lastName the last name of this hourly programmer
 * @param socialSecurityNumber the social security number of this hourly programmer
 * @param wage the wage per hour for this hourly programmer
 * @param hours the number of hours worked for a week for this hourly programmer
 * @throws IllegalArgumentException if wage is less than 0 or if hours are less than 0 or greater than 168
 */
public HourlyProgrammer(String firstName, String lastName,
String socialSecurityNumber,
double wage, double hours) {
super(firstName, lastName, socialSecurityNumber);
this.wage = wage;
this.hours = hours;

if (wage < 0.0) { // validate wage
throw new IllegalArgumentException(
  "Hourly wage must be >= 0.0");
}

if ((hours < 0.0) || (hours > 168.0)) { // validate hours
throw new IllegalArgumentException(
  "Hours worked must be >= 0.0 and <= 168.0");
}

this.wage = wage;
this.hours = hours;
} 

/**
 * Sets the wage per hour for this hourly programmer.
 * @param wage the wage per hour for this hourly programmer
 * @throws IllegalArgumentException if wage is less than 0
 */
public void setWage(double wage) {
if (wage < 0.0) { // validate wage
throw new IllegalArgumentException(
  "Hourly wage must be >= 0.0");
}

this.wage = wage;
} 

/**
 * Returns the wage per hour for this hourly programmer.
 * @return the wage per hour for this hourly programmer
 */
public double getWage() {
return wage;
} 
/**
 * Sets the number of hours worked for a week for this hourly programmer.
 * @param hours the number of hours worked for a week for this hourly programmer
 * @throws IllegalArgumentException if hours are less than 0 or greater than 168
 */
public void setHours(double hours) {
if ((hours < 0.0) || (hours > 168.0)) { // validate hours
throw new IllegalArgumentException(
  "Hours worked must be >= 0.0 and <= 168.0");
}

this.hours = hours;
} 

/**
 * Returns the number of hours worked for a week for this hourly programmer.
 * @return the number of hours worked for a week for this hourly programmer
 */
public double getHours() {
return hours;
} 

/**
 * Calculates the payment amount for this hourly programmer.
 * @return the payment amount for this hourly programmer
 */
@Override                                                           
public double getPaymentAmount() {                                            
if (getHours() <= 40) { // no overtime                           
return getWage() * getHours();   
}
else {                                                             
return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
}
}

                                  

//return String representation of HourlyProgrammer object              
@Override                                                             

public String toString() {
	   return String.format("hourly Programmer: %s %s\n"
	         + "social security number: %s\n"
	         + "hourly wage: $%,.2f hourly worked: $%.2f",
	         getFirstName(), getLastName(), getSocialSecurityNumber(),getWage(),getHours());
	}
}

