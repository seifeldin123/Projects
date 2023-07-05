/**
 * name: Seifeldin Eid
 * student number: 041084185
 * Professor name: Siju Philip
 * due date: jun 2nd 2023
 */
/*
 * The Unitconverter interface defines the contract for implementing unit conversion functionality.
 * Classes that implement this interface should provide a method to convert a given value from one unit to another.
 */
package pkgUnitConverter;

/**
 * The Unitconverter interface defines the contract for implementing unit conversion functionality.
 * Classes that implement this interface should provide a method to convert a given value from one unit to another.
 * @author Seifeldin
 */
public interface Unitconverter {
    
    /**
     * Converts the specified value from one unit to another.
     *
     * @param x the value to be converted
     * @return the converted value
     */
    public double convert(double x);
    

}
