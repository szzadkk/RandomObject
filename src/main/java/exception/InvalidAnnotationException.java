package exception;

/**
 * @author yanming
 * @date 2019-09-06 22:33
 */
public class InvalidAnnotationException extends RuntimeException {
    private String message;

    public InvalidAnnotationException() {
        super();
    }

    public InvalidAnnotationException(String message) {
        super(message);
    }

    public InvalidAnnotationException(String message, Throwable cause) {
        super(message, cause);
    }
}
