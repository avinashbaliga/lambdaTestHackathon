package exceptions;

public class TestPropertyNotFoundException extends RuntimeException {
    public TestPropertyNotFoundException(String message) {
        super(message);
    }
}
