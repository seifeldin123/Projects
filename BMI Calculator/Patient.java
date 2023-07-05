/*
 * Student Name: Seifeldin Eid
 * Lab Professor: Leanne Seaward
 * Due Date: Jan 26, 2023
 * Modified: Jan 27, 2023
 * Description: This class will create  a report of patients records and months and provinces.
 * and then will print out the recovered patients records.        
 */
package assignment1;

import java.time.LocalDateTime;

public class Patient {
	//23W CST8284
	//Assignment 1: Patient.java

	//This system maintains important health information about a patient.
	//Note: This class assumes values passed to the set methods are correct.
	// REVIEW THIS FILE AND ASSIGNMENT INSTRUCTIONS CAREFULLY BEFORE YOU START OFF!!

	/**
	 * first name of the patient.
	 */
	private String firstname;
	/**
	 * last name of the patient.
	 */
	private String lastname;
	/**
	 *gender of the patient.
	 */
	private String gender;
	/**
	 *birth year of the patient.
	 */
	private int birthYear;
	/**
	 *birth month of the patient.
	 */
	private int birthMonth;
	/**
	 *birth day of the patient.
	 */
	private int birthDay;
	/**
	 *height of the patient.
	 */
	private double Height;
	/**
	 *weight of the patient.
	 */
	private double Weight;
	



	/**
	 * The default constructor.
	 */

	public Patient() {
	}
	

	/**
	 * This constructor sets the patient first name, last name, gender, year, month, day, height, weight
	 * @param fname The firstname of the patient.
	 * @param lname the lastname of the patient.
	 * @param gender is the gender of the patient.
	 * @param birth is the birth year of the patient
	 * @param birthM is the birth month of the patient
	 * @param birthD is the birth day of the patient
	 * @param height is the height of the patient
	 * @param weight is the weight of the patient
	 */

	public Patient(String fname,String lname,String gender, int birth, int birthM,int birthD, double height, double weight) {
		this.firstname= fname;
		this.lastname= lname;
		this.gender=gender;
		this.birthYear = birth;
		this.birthMonth = birthM;
		this.birthDay = birthD;
		this.Height = height;
		this.Weight = weight;
	}
		


	/**
	 * Returns the firstname for this patient.
	 * @return the firstname for this patient.
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Sets the first name for this patient.
	 * @param firstname The firstname for this patient.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * Returns the lastname for this patient.
	 * @return the lastname for this patient.
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * Sets the last name for this patient.
	 * @param lastname The lastname for this patient.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * Returns the gender for this patient.
	 * @return the gender for this patient.
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * Sets the gender for this patient.
	 * @param gender The gender for this patient.
	 */

	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * Returns the birth year for this patient.
	 * @return the birth year for this patient.
	 */
	public int getBirthYear() {
		return birthYear;
	}
	/**
	 * Sets the birth year  for this patient.
	 * @param birthYear The birth year for this patient.
	 */

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	/**
	 * Returns the birth month for this patient.
	 * @return the birthMonth for this patient.
	 */
	public int getBirthMonth() {
		return birthMonth;
	}
	/**
	 * Sets the birth month for this patient.
	 * @param birthMonth The birth month for this patient.
	 */

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	/**
	 * Returns the birth day for this patient.
	 * @return the birth day for this patient.
	 */
	public int getBirthDay() {
		return birthDay;
	}
	/**
	 * Sets the birth day for this patient.
	 * @param birthDay The birth day for this patient.
	 */

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * Returns the height for this patient.
	 * @return the height for this patient.
	 */
	public double getHeight() {
		return Height;
	}

	/**
	 * Sets the height for this patient.
	 * @param height The height for this patient.
	 */
	public void setHeight(double height) {
		Height = height;
	}
	/**
	 * Returns the weight for this patient.
	 * @return the weight for this patient.
	 */
	public double getWeight() {
		return Weight;
	}

	/**
	 * Sets the weight for this patient.
	 * @param weight The weight for this patient.
	 */
	public void setWeight(double weight) {
		Weight = weight;
	}

// TO DO 4: THIS PORTION OF CODE SHOULD DISPLAY ALL THE PATIENT'S HEALTH DATA. DO NOT MISS ANY DATA / INFORMATION
	/**
	 * this method is used to calculate the age of the patient, by doing simple math
	 * local date time - the year the patient was born.
	 * @return the age of the patient
	 * */
	public int Calculateage() {
		int age = LocalDateTime.now().getYear() - birthYear;
		return age;
	}
	/**
	 * this method is used to calculate the maximum heart rate of a patient by doing some simple math.
	 * @return the maximum heart rate of the patient.
	 */
	public double PatientsHeartrate() {
		int maximumheartrate= 220 - Calculateage();
		return maximumheartrate;
	}
	/**
	 * this method is used to calculate the minimum target heart rate of a patient by doing some simple math.
	 * @return the minimum target heart rate of the patient.
	 */
	public double PatientsMinHeartrate(){
	double minimumtargetheartrate = (50 * PatientsHeartrate()) /100;
	return minimumtargetheartrate;
	}/**
	 * this method is used to calculate the maximum target heart rate of a patient by doing some simple math.
	 * @return the maximum target heart rate of the patient.
	 */
	
	public double PatientMaxHeartrate(){
		
	double maximumtargetheartrate = (85 * PatientsHeartrate()) /100;
	return maximumtargetheartrate;
	}
	/**
	 * this method is used to calculate THE PATIENT'S Body Mass Index (BMI) by doing some simple math.
	 * @return THE PATIENT'S Body Mass Index (BMI)
	 */
	public double getBMI() {
	   return (getWeight() * 703) / (getHeight() * getHeight());
	} 
/**
 * this method is used to SHOW ALL HEALTH DATA of the patient.
 */
	public void displayMyHealthData() 
	{ 
	   System.out.printf("first name %s\n",firstname);
	   System.out.printf("last name %s\n",lastname);
	   System.out.printf("Gender %S \n", gender);
	   System.out.printf("year of birth %d, month of birth %d , day of birth %d \n", birthYear,birthMonth,birthDay);
	   System.out.printf("height %.1f\n",Height);
	   System.out.printf("weight %.1f\n",Weight);
	   System.out.printf("patient age %d, BMI %.1f, maximum heart rate %.1f, target heart rate range( minimum heart %.1f and maximum heart %.1f) \n",Calculateage(), getBMI(),PatientsHeartrate(),PatientsMinHeartrate(),PatientMaxHeartrate() );
	   
	   System.out.println("BMI VALUES");
	   System.out.println("Underweight: less than 18.5");
	   System.out.println("Normal:      between 18.5 and 24.9");
	   System.out.println("Overweight:  between 25 and 29.9");
	   System.out.println("Obese:       30 or greater");   
	} 

} // end class Patient





