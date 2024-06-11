package cheboksarov.blps_lab1.exceptions;

public class CoefficientNotFoundException extends RuntimeException{
    public CoefficientNotFoundException() {
        super();
    }

    public CoefficientNotFoundException(String message) {
        super(message);
    }

    public CoefficientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoefficientNotFoundException(Throwable cause) {
        super(cause);
    }
}
