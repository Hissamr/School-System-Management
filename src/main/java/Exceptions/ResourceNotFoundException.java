package Exceptions;

/**
 * This class is used to handle duplicate resource exceptions.
 * It extends the RuntimeException class.
 */

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }

}
