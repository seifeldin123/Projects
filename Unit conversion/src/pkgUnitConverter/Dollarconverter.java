/**
 * name: Seifeldin Eid
 * student number: 041084185
 * Professor name: Siju Philip
 * due date: jun 2nd 2023
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pkgUnitConverter;

/**
 * The Dollarconverter class is used to convert currency from dirhams to dollars.
 * It implements the Unitconverter interface.
 * @author seifeldin eid
 */
/*
 * The Dollarconverter class implements the Unitconverter interface and provides
 * functionality to convert a given amount in dirhams to dollars.
 */
public class Dollarconverter implements Unitconverter {

    /**
     * Constants factors for dollar to dihrams conversion
     */
    private final double dollar = 3.67;
    
      /**
    * empty dollar convert constructor
    */
    public Dollarconverter(){
        
    }
   /**
     * Converts the specified amount in dirhams to dollars.
     *
     * @param value the amount in dirhams to be converted
     * @return the equivalent amount in dollars
     */
      @Override
    public double convert(double value) {
        return value * dollar;
    }


}
