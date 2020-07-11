package com.wish.Exception;
/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
public class CustomException extends RuntimeException {

    /**
     * @param errorMessage - String
     * @throw message exception
     */
    private final String errorMessage;

    public CustomException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static RuntimeException throwException(String message) {
        return new CustomException(message);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
