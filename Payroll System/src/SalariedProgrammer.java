/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: apr 2, 2023
 * Modified: mar 30th, 2023
 * about: This class represents a salaried programmer, who earns a fixed weekly salary.
 *It extends the abstract class Programmer and implements the Payme interface.
*/
package lab6;
/**
 * @author Seifeldin Eid
 *This class represents a salaried programmer, who earns a fixed weekly salary.
 *It extends the abstract class Programmer and implements the Payme interface.
*/

public class SalariedProgrammer extends Programmer  {
private double weeklySalary; // the fixed weekly salary of the salaried programmer
/**
 * Constructor for the SalariedProgrammer class.
 * @param firstName the first name of the programmer
 * @param lastName the last name of the programmer
 * @param socialSecurityNumber the social security number of the programmer
 * @param weeklySalary the fixed weekly salary of the salaried programmer
 * @throws IllegalArgumentException if the weekly salary is less than 0
*/
public SalariedProgrammer(String firstName, String lastName, 
String socialSecurityNumber, double weeklySalary) {
super(firstName, lastName, socialSecurityNumber); 
this.weeklySalary = weeklySalary;

if (weeklySalary < 0.0) {
throw new IllegalArgumentException(
  "Weekly salary must be >= 0.0");
}

this.weeklySalary = weeklySalary;
} 

/**
 * Sets the weekly salary of the salaried programmer.
 * @param weeklySalary the new weekly salary
 * @throws IllegalArgumentException if the weekly salary is less than 0
*/
public void setWeeklySalary(double weeklySalary) {
if (weeklySalary < 0.0) {
throw new IllegalArgumentException(
  "Weekly salary must be >= 0.0");
}

this.weeklySalary = weeklySalary;
} 
/**
 * Returns the weekly salary of the salaried programmer.
 * @return the weekly salary
*/
public double getWeeklySalary() {
return weeklySalary;
} 

/**
 * Calculates the payment amount earned by the salaried programmer.
 * Overrides the abstract method in the Programmer class.
@return the weekly salary of the salaried programmer
*/
@Override                                                           
public double getPaymentAmount() {                                          
return getWeeklySalary();                                        
}

//return String representation of SalariedProgrammer object   
@Override                                     
public String toString() {
	   return String.format("salaried Programmer: %s %s\n"
	         + "social security number: %s\n"
	         + "weekly salary:$%.2f",
	         getFirstName(), getLastName(), getSocialSecurityNumber(),getWeeklySalary());
	}
}

