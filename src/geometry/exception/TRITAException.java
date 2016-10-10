package geometry.exception;

/**
 * A base exception
 *
 * Created by egorbachev on 10/7/16.
 */
public class TRITAException extends Exception {
    public TRITAException() {
        super();
    }

    /**
     * @param message
     */
    public TRITAException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public TRITAException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public TRITAException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public TRITAException(String message, Throwable cause,
                         boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
