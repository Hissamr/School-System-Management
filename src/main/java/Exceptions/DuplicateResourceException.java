package Exceptions;

/**
 * This class is used to handle duplicate resource exceptions.
 * It extends the RuntimeException class.
 */

public class DuplicateResourceException extends RuntimeException{

    public DuplicateResourceException(String message){
        super(message);
    }

}
