package Exceptions;

/**
 * This class is used to handle duplicate resource exceptions.
 * It extends the RuntimeException class.
 */

public class InvalidInputException extends RuntimeException{

    public InvalidInputException(String message){
        super(message);
    }

}
