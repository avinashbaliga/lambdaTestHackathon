package exceptions;

public class DriverNotInitialisedException extends RuntimeException{
    public DriverNotInitialisedException(String message){
        super(message);
    }
}
