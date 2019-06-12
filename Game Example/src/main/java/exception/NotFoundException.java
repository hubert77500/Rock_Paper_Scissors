package exception;

/**
 * This is the wrapper to Throw custom Exceptions to use in developed try / catches
 * regarding what can happen in the logic fails and map error occurs in the code development.
 */
public class NotFoundException extends Exception {

    private static final long serialVersionUID = -4601426150169300703L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
