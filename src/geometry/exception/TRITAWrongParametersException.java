package geometry.exception;

/**
 * Created by egorbachev on 10/7/16.
 */
public class TRITAWrongParametersException extends TRITAException {
    public TRITAWrongParametersException() {
        super();
    }

    public TRITAWrongParametersException(String message) {
        super(message);
    }

    public TRITAWrongParametersException(Throwable cause) {
        super(cause);
    }

    public TRITAWrongParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public TRITAWrongParametersException(String message, Throwable cause,
             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
