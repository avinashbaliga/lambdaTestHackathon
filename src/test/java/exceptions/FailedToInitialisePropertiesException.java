package exceptions;

public class FailedToInitialisePropertiesException extends RuntimeException {
    public FailedToInitialisePropertiesException(String message) {
        super(message);
    }
}
