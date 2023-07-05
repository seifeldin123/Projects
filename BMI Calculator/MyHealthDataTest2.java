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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyHealthDataTest2 {
	/**
	 * created a new object names patient1 taking in the details of the patient: full name, date of birth, height, and weight)
	 * declared a double variable called weight.
	 * declared a double variable called height.
	 * declared a double variable called result that takes in (weight * 703) and divide it by (height * height)
	 * using the JUnit syntax, used assertEquals and checks if the expected (BMI calculation) is equal to the actual (result) or not
	 * Test Successful 
	 **/
	@Test
	public void testBMI() {
		System.out.println("BMI tester: Success");
		Patient patient1 = new Patient("Sam","Paul", "M", 1993, 04, 23, 70.4, 200.5);
		double weight = 200.5;
		double height = 70.4;
		double result = (weight * 703) / (height * height);
		assertEquals(patient1.getBMI(), result);
	}
	/**
	 * created a new object names patient1 taking in the details of the patient: full name, date of birth, height, and weight)
	 * declared a double variable called weight.
	 * declared a double variable called height.
	 * declared a double variable called result that takes in (weight * 703) and divide it by (height * height)
	 * using the JUnit syntax, used assertEquals and checks if the expected (BMI calculation) is equal to the actual (result) or not
	 * Test Failed 
	 **/
	@Test
	public void testBMI2() {
		System.out.println("BMI tester: Failed");
		Patient patient2 = new Patient("Sam","Paul", "M", 1993, 04, 23, 70.4, 201.5);
		double weight = 200.5;
		double height = 70.4;
		double result = (weight * 703) / (height * height);
		assertEquals(patient2.getBMI(), result);
	}
}
