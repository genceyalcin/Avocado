package com.genceyalcin.util3D;

/**
 * Exception thrown when illegal operations are done pertaining to mismatching
 * of vector dimensions.
 * 
 * @author Hamza Butt
 * @version 5.12.2020
 */
public class InvalidVectorDimensionsException extends Exception {

    /**
     * Serial version UID for the exception
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an InvalidVectorDimensions exception with an error message
     * 
     * @param message
     *            The error message
     */
    public InvalidVectorDimensionsException(String message) {
        super(message);
    }

}
