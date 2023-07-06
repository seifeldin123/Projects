/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: apr 2, 2023
 * Modified: mar 30th, 2023
 * about: the `BasePlusCommissionProgrammer` class extends `CommissionProgrammer` and represents programmers
 * who earn a commission based on their gross weekly sales and a commission rate, as well as a base salary.
 */
package lab6;


/**
 * The `BasePlusCommissionProgrammer` class extends `CommissionProgrammer` and represents programmers
 * who earn a commission based on their gross weekly sales and a commission rate, as well as a base salary.
 */
public class BasePlusCommissionProgrammer extends CommissionProgrammer { 

private double baseSalary; // base salary per week

/**
 * Creates a new `BasePlusCommissionProgrammer` object with the specified first name, last name,
 * social security number, gross sales, commission rate, and base salary.
 *
 * @param firstName the first name of the programmer
 * @param lastName the last name of the programmer
 * @param socialSecurityNumber the social security number of the programmer
 * @param grossSales the gross weekly sales of the programmer
 * @param commissionRate the commission rate of the programmer
 * @param baseSalary the base salary per week of the programmer
 * @throws IllegalArgumentException if the base salary is less than 0
 */
public BasePlusCommissionProgrammer(String firstName, String lastName, 
String socialSecurityNumber,double grossSales, double commissionRate, double baseSalary) {
super(firstName, lastName, socialSecurityNumber,  grossSales, commissionRate);
this.baseSalary = baseSalary;

if (baseSalary < 0.0) { // validate baseSalary                  
throw new IllegalArgumentException("Base salary must be >= 0.0");
}

this.baseSalary = baseSalary;                
}

/**
 * Sets the base salary per week of the programmer to the specified amount.
 *
 * @param baseSalary the base salary per week to set
 * @throws IllegalArgumentException if the base salary is less than 0
 */
public void setBaseSalary(double baseSalary) {
if (baseSalary < 0.0) { // validate baseSalary                  
throw new IllegalArgumentException("Base salary must be >= 0.0");
}

this.baseSalary = baseSalary;                
} 

/**
 * Sets the base salary per week of the programmer to the specified amount.
 *
 * @param baseSalary the base salary per week to set
 * @throws IllegalArgumentException if the base salary is less than 0
 */
public double getBaseSalary() {
return baseSalary;
}

//calculate earnings; override method earnings in CommissionProgrammer

//MODIFY THIS PORTION. WHY WILL THIS PORTION OF YOUR CODE REQUIRE MODIFICATION?
//PROVIDE THE ANSWER TO THIS QUESTION TO YOUR PROFESSOR DURING DEMO

/*answer
it does not need to be modified,  It overrides the getPaymentAmount() method in the CommissionProgrammer class 
to calculate the earnings of a CommissionProgrammer object by adding the base salary to the commission earnings
calculated by the superclass getPaymentAmount() method.
*/
@Override                                                            
public double getPaymentAmount() {                                             
return getBaseSalary() + super.getPaymentAmount();                        

} 

/**
 * Returns a string representation of the `BasePlusCommissionProgrammer` object.
 *
 * @return a string representation of the object
 */
@Override     
public String toString() {
	   return String.format("base-plus Commission Programmer: %s %s\n"
	         + "social security number: %s\n"
	         + "gross Sales: $%,.2f ; commission rate: %.2f ; base salary: $%,.2f",
	         getFirstName(), getLastName(), getSocialSecurityNumber(), getGrossSales(),
	         getCommissionRate(), getBaseSalary());
	}

}



