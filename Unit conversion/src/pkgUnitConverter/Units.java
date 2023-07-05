/**
 * name: Seifeldin Eid
 * student number: 041084185
 * Professor name: Siju Philip
 * due date: jun 2nd 2023
 */

package pkgUnitConverter;


/**
 * The Units class is the general class that  represents a number conversion unit. It provides
 * functionality to convert number based on a specific unit converter
 * implementation. The default unit converter is set to FCconverter, which
 * converts Fahrenheit to Celsius. The class also allows changing the unit
 * converter dynamically.
 *
 * @author seifeldin
 */
/*
 * The Units class represents a number conversion unit.
 * It provides functionality to convert random number based on a specific unit converter implementation.
 */
public class Units {

    /**
     * the conversion type as Unitconverter interface object
     */
    private Unitconverter uni;

      /**
     * no-arg constructor initializes units behaviour/strategy to that of a
     * FCconverter
     */
    public Units() {
        this.uni = new FCconverter();
    }


/**
 * Converts a value using the provided Unitconverter.
 * @param value the value to be converted
 * @return the converted value
*/
    public double converting(double value) {
        return uni.convert(value);
    }

    /**
     * Changes the behavior of the unit converter to the specified
     * implementation.
     *
     * @param uni the new unit converter to be used
     */
    public void changeBehaviourTo(Unitconverter uni) {

        this.uni = uni;
    }
}
