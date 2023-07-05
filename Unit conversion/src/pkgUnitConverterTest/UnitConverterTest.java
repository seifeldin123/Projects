/**
 * name: Seifeldin Eid
 * student number: 041084185
 * Professor name: Siju Philip
 * due date: jun 2nd 2023
 */

package pkgUnitConverterTest;

import pkgUnitConverter.Units;
import pkgUnitConverter.*;

/**
 * The UnitConverterTest class is used to test the functionality of various unit
 * converter classes. It includes tests for converting Fahrenheit to Celsius,
 * Celsius to Fahrenheit, dollar to dirham, and dirham to dollar. The results
 * are printed to the console.
 *
 * @author Seifeldin eid
 */

/*
 * The UnitConverterTest class is a simple class used to test the functionality
 * of different unit converter classes, including Fahrenheit to Celsius conversion,
 * Celsius to Fahrenheit conversion, dollar to dirham conversion, and dirham to dollar conversion.
 */
public class UnitConverterTest {
   

    /**
     * The main method is the entry point of the application. It performs unit
     * conversion tests and prints the results to the console.
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        Units a = new Units();
       System.out.printf("%5.2f Celsius in Farhrenheit is: %5.2f\n",70.00,a.converting(70.00));

        a.changeBehaviourTo(new CFconverter());
        System.out.printf("%5.2f Farhrenheit in Celsius is: %5.2f \n", 20.0, a.converting(20.00));

        a.changeBehaviourTo(new Dollarconverter());
        System.out.printf("%5.2f Dollars in Dirhams is: %5.2f \n", 20.0, a.converting(20.0));
        
        a.changeBehaviourTo(new Dirhamconverter());
        System.out.printf("%5.2f Dirhams in Dollars is: %5.2f \n", 20.0, a.converting(20.0));
    }
}
