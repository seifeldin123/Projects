/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: apr 2, 2023
 * Modified: mar 30th, 2023
 * about: The Payme interface defines the basic functionality of an object that can calculate its payment amount.
 */
package lab6;
/**
 * The Payme interface defines the basic functionality of an object that can calculate its payment amount.
 * @author Seifeldin Eid
 *
 */
public interface Payme {
	/**
	 * This method calculates the payment amount for the object that implements this interface.
	 * @return The payment amount as a double value.
	*/
	double getPaymentAmount();
}
