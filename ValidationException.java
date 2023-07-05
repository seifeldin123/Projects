/*
* Student Name: Seifeldin Eid
* Student Number:041084185
* Course & Section #: 23SECST8288_021
* Declaration: The ValidationException class represents an exception that is thrown when data is not in a valid format. 
* This is my own original work and is free from Plagiarism.
*/
package businesslayer;

/**
 * The ValidationException class represents an exception that is thrown when
 * data is not in a valid format. It is a subclass of the Exception class. This
 * exception can be used to handle validation errors or data format issues in
 * the business layer of an application.
 *
 * @author Seifeldin Eid
 */

public class ValidationException extends Exception {

    /**
     * Constructs a new ValidationException with a default error message. The
     * default error message is "Data not in valid format".
     */
    public ValidationException() {
        super("Data not in valid format");
    }

    /**
     * Constructs a new ValidationException with the specified error message.
     *
     * @param message The error message for the exception.
     */
    public ValidationException(String message) {
        super(message);
    }


    
    public ValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }


    public ValidationException(Throwable throwable) {
        super(throwable);
    }
}
