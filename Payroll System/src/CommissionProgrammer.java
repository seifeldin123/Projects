/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: apr 2, 2023
 * Modified: mar 30th, 2023
 * about: *The CommissionProgrammer class extends the Programmer class and represents a programmer who earns commission based on their gross sales and commission rate.
 */
package lab6;

/**
  *The CommissionProgrammer class extends the Programmer class and represents a programmer who earns commission based on their gross sales and commission rate.
 */
public class CommissionProgrammer extends Programmer { 

private double grossSales; // gross weekly sales
private double commissionRate; // commission percentage

/**
 * Constructs a CommissionProgrammer object with the specified first name, last name, social security number, gross sales, and commission rate.
 *
 * @param firstName the first name of the CommissionProgrammer
 * @param lastName the last name of the CommissionProgrammer
 * @param socialSecurityNumber the social security number of the CommissionProgrammer
 * @param grossSales the gross sales of the CommissionProgrammer
 * @param commissionRate the commission rate of the CommissionProgrammer
 * @throws IllegalArgumentException if the commission rate is not greater than 0.0 and less than 1.0, or if the gross sales is less than 0.0
 */
public CommissionProgrammer(String firstName, String lastName, 
String socialSecurityNumber, 
double grossSales, double commissionRate) {
super(firstName, lastName, socialSecurityNumber);
this.grossSales = grossSales;
this.commissionRate = commissionRate;


if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate 
throw new IllegalArgumentException(
  "Commission rate must be > 0.0 and < 1.0");
}

if (grossSales < 0.0) { // validate
throw new IllegalArgumentException("Gross sales must be >= 0.0");
}

this.grossSales = grossSales;
this.commissionRate = commissionRate;
} 

/**
 * Sets the gross sales of the CommissionProgrammer to the specified value.
 *
 * @param grossSales the new gross sales of the CommissionProgrammer
 * @throws IllegalArgumentException if the gross sales is less than 0.0
 */
public void setGrossSales(double grossSales) {
if (grossSales < 0.0) { // validate
throw new IllegalArgumentException("Gross sales must be >= 0.0");
}

this.grossSales = grossSales;
} 

/**
 * Returns the gross sales of the CommissionProgrammer.
 *
 * @return the gross sales of the CommissionProgrammer
 */
public double getGrossSales() {
return grossSales;
} 


/**
 * Sets the commission rate of the CommissionProgrammer to the specified value.
 *
 * @param commissionRate the new commission rate of the CommissionProgrammer
 * @throws IllegalArgumentException if the commission rate is not greater than 0.0 and less than 1.0
 */
public void setCommissionRate(double commissionRate) {
if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
throw new IllegalArgumentException(
  "Commission rate must be > 0.0 and < 1.0");
}

this.commissionRate = commissionRate;
} 

/**
 * Calculates the payment amount for the CommissionProgrammer, based on their gross sales and commission rate.
 *
 * @return the payment amount for the CommissionProgrammer
 */
public double getCommissionRate() {
return commissionRate;
} 

/**
 * Calculates the payment amount for the CommissionProgrammer, based on their gross sales and commission rate.
 *
 * @return the payment amount for the CommissionProgrammer
 */
@Override                                                           
public double getPaymentAmount() {                                            
return getCommissionRate() * getGrossSales() ;                   
}
//return String representation of CommissionProgrammer object

@Override 
public String toString() {
	   return String.format("Commission Programmer : %s %s\n"
	         + "social security number: %s\n"
	         + "gross Sales: $%,.2f ; commission rate: %.2f ",
	         getFirstName(), getLastName(), getSocialSecurityNumber(), getGrossSales(),
	         getCommissionRate());
	}
}

