/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: apr 2, 2023
 * Modified: mar 30th, 2023
 * about: The PaymeInterfaceTest class demonstrates polymorphic behavior of objects that
 * implement the Payme interface. It creates an array of Payme objects and 
 * assigns different types of Payme objects to its elements. It then processes 
 * each element of the array generically using polymorphism and outputs the 
 * details of each Payme object along with its payment amount.
 */
package lab6;
/**
 * The PaymeInterfaceTest class demonstrates polymorphic behavior of objects that
 * implement the Payme interface. It creates an array of Payme objects and 
 * assigns different types of Payme objects to its elements. It then processes 
 * each element of the array generically using polymorphism and outputs the 
 * details of each Payme object along with its payment amount.
 */
public class PaymeInterfaceTest  {
	  /**
     * The main method creates an array of Payme objects and assigns different
     * types of Payme objects to its elements. It then processes each element of
     * the array generically using polymorphism and outputs the details of each 
     * Payme object along with its payment amount.
     * 
     * @param args the command-line arguments
     */
public static void main(String[] args) {
	

	       Payme[] paymeObjects = new Payme[6];
			paymeObjects[0]= new Invoice("22776", "Brakes",3,300); 
			paymeObjects[1]= new Invoice("33442", "Gear",5, 90.99);
			paymeObjects[2]= new SalariedProgrammer("Chioma","Eid","345-67-0001",320.00 );
			paymeObjects[3]= new HourlyProgrammer("Amara","Eid","234-56-7770",18.95,40.00);
			paymeObjects[4]= new CommissionProgrammer("peter","Eid","123-45-6999",16500.00,0.44 );
			paymeObjects[5]= new BasePlusCommissionProgrammer("Esther","Eid","102-34-5888",1200,0.04,720);

 System.out.println(
    "Payment for Invoices and Programmers are processed polymorphically:\n"); 

 // generically process each element in array paymeObjects
 
 for (Payme currentPayme : paymeObjects) {
    // output currentPayme and its appropriate payment amount
    System.out.printf("%s \n",currentPayme.toString()); 
       
    if (currentPayme instanceof BasePlusCommissionProgrammer) {
       // downcast Payme reference to 
       // BasePlusCommissioProgrammer reference
       BasePlusCommissionProgrammer programmer = 
          (BasePlusCommissionProgrammer) currentPayme;

       double oldBaseSalary = programmer.getBaseSalary();
       programmer.setBaseSalary(1.10 * oldBaseSalary);
       System.out.printf(
          "new base salary with 10%% increase is: $%,.2f\n",
          programmer.getBaseSalary());
         }
   System.out.printf("payment due: $%,.2f\n\n",currentPayme.getPaymentAmount());
 }
}
}


