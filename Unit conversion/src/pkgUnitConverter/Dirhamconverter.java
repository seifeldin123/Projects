/**
 * name: Seifeldin Eid
 * student number: 041084185
 * Professor name: Siju Philip
 * due date: jun 2nd 2023
 */

package pkgUnitConverter;

/**
 * The Dirhamconverter class is used to convert currency from dollars to dirhams.
 * It implements the Unitconverter interface.
 * @author seifeldin eid
 */
/*
 * The Dirhamconverter class implements the Unitconverter interface and provides
 * functionality to convert a given amount in dollars to dirhams.
 */
public class Dirhamconverter implements Unitconverter{

    /**
     * Constants factors for  dirhams to dollars conversion
     */
    private final double dirhams = 0.27;
   /**
    * empty dirham convert constructor
    */
    public Dirhamconverter(){
        
    }
    /**
     * Converts the specified amount in dollars to dirhams.
     *
     * @param value the amount in dollars to be converted
     * @return the equivalent amount in dirhams
     */
      @Override
    public double convert(double value) {
        return value * dirhams;
    }


}
