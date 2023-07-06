/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: apr 2, 2023
 * Modified: mar 30th, 2023
 * about: Programmer is an abstract superclass that implements the Payme interface.
 */
package lab6;

/**
 * @author Seifeldin Eid
 * Programmer is an abstract superclass that implements the Payme interface.
 */

public abstract class Programmer implements Payme  {

private String firstName;
private String lastName;
private String socialSecurityNumber;

/**
 * Constructs a Programmer object with the given first name, last name, and social security number.
 * 
 * @param first the first name of the programmer
 * @param last the last name of the programmer
 * @param ssn the social security number of the programmer
 */
public Programmer(String first, String last, String ssn) {
firstName = first;
lastName = last;
socialSecurityNumber = ssn;
}

/**
 * Returns the first name of the programmer.
 * 
 * @return the first name of the programmer
 */
public String getFirstName() {
	return firstName;
}
/**
 * Sets the first name of the programmer.
 * 
 * @param firstName the new first name of the programmer
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * Returns the last name of the programmer.
 * 
 * @return the last name of the programmer
 */
public String getLastName() {
	return lastName;
}
/**
 * Sets the last name of the programmer.
 * 
 * @param lastName the new last name of the programmer
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}

/**
 * Returns the social security number of the programmer.
 * 
 * @return the social security number of the programmer
 */
public String getSocialSecurityNumber() {
	return socialSecurityNumber;
}

/**
 * Returns the social security number of the programmer.
 * 
 * @return the social security number of the programmer
 */
public void setSocialSecurityNumber(String socialSecurityNumber) {
	this.socialSecurityNumber = socialSecurityNumber;
}


//return String representation of Programmer object
@Override
public String toString() {
return String.format("%s %s\n%s: %s\n%s: %s", 
getFirstName(), getLastName(), getSocialSecurityNumber());
} 


//Note: We do NOT implement Payme method getPaymentAmount() here. 
//THEREFORE, TO AVOID A COMPILATION ERROR, YOU SHOULD DECLARE THIS CLASS AS....??
public abstract double getPaymentAmount(); /** No implementation here. DO YOU KNOW WHY? What should this method be?*/

} 


