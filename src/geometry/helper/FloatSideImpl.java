package geometry.helper;

import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.getLogger;

import geometry.contract.Side;
import geometry.exception.TRITAWrongValueException;

/**
 * A float implementation of the Side interface.
 *
 * Created by egorbachev on 10/7/16.
 */
public class FloatSideImpl implements Side {
    private static Logger logger = getLogger(FloatSideImpl.class);

    private float side;

    /**
     * @param side of figure
     */
    public FloatSideImpl(Object side) throws TRITAWrongValueException {
        if (side instanceof String) {
            try {
                this.side = Float.parseFloat((String) side);
            } catch (NumberFormatException | NullPointerException e) {
                throw new TRITAWrongValueException("Unable to parse value from '" +
                    side + "': " + e);
            }
        } else {
            this.side = (float) side;
        }

        if (this.side <= 0) {
            throw new TRITAWrongValueException("Value '" + this.side +
                "' is equal or less than zero");
        }

    }

    @Override
    public Object getSize() {
        return side;
    }

    @Override
    public String toString() {
        return String.valueOf(side);
    }

    @Override
    public int compareTo(Object other) {
        logger.debug("Comparing " + side + " with " + other + ": " +
            Float.compare(side, new Float(other.toString())));
        return Float.compare(side, new Float(other.toString()));
    }
}
