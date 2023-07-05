/**
 * name: Seifeldin Eid
 * student number: 041084185
 * Professor name: Siju Philip
 * due date: jun 2nd 2023
 */

package pkgUnitConverter;

/**
 * The FCconverter class is used to convert temperatures from Fahrenheit to Celsius.
 * It implements the Unitconverter interface.
 * The conversion formula used is: Celsius = (Fahrenheit - 32) / 1.8.
 * 
 * @author seifeldin
 */

/*
 * The FCconverter class is used to convert temperatures from Fahrenheit to Celsius.
 * It implements the Unitconverter interface.
 */
public class FCconverter implements Unitconverter {
/**
     * Constants factors for  fahrenheit to celsius conversion
     */
    private final double convFactor = 1.8;
    /**
     * addition Constants factors for  fahrenheit to celsius conversion
     */
    private final double convOrigin = 32.0;

      /**
    * empty fahrenheit convert constructor
    */
    public FCconverter(){
        
    }
    /**
     * @param value the amount  in Fahrenheit to be converted
     * @return equivalent in Celsius
     */
    @Override
    public double convert(double value) {
        return (value - convOrigin) / convFactor;
    }

}
