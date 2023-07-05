/**
 * name: Seifeldin Eid
 * student number: 041084185
 * Professor name: Siju Philip
 * due date: jun 2nd 2023
 */



package pkgUnitConverter;

/**
 * The CFconverter class is used to convert temperatures from   Celsius to Fahrenheit.
 * It implements the Unitconverter interface.
 * The conversion formula used is: fahrenheit = Celsius * 1.8 + 32
 * 
 * @author seifeldin
 */
/*
 * The CFconverter class is used to convert temperatures from celsius to Fahrenheit.
 * It implements the Unitconverter interface.
 */
public class CFconverter implements Unitconverter {
    /**
     * Constants factors for celsius fahrenheit conversion
     */
    private final double convFactor = 1.8;
    /**
     * addition  Constants factors for celsius fahrenheit conversion
     */
    private final double convOrigin = 32.0;

    /**
     * emtpy construction for default conversion
     */
    public CFconverter(){
        
    }
    
    /**
     * @param value the amount in Celsius to be converted
     * @return equivalent in Fahrenheit
     */

    @Override
    public double convert(double value) {
        return value * convFactor + convOrigin;
    }


}
