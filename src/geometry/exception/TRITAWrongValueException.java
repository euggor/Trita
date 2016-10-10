package geometry.exception;

/**
 * Created by egorbachev on 10/10/16.
 */
public class TRITAWrongValueException extends TRITAException {
    public TRITAWrongValueException() {
        super();
    }

    public TRITAWrongValueException(String message) {
        super(message);
    }

    public TRITAWrongValueException(Throwable cause) {
        super(cause);
    }

    public TRITAWrongValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public TRITAWrongValueException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
