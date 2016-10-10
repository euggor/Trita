package geometry.helper;

import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.getLogger;

import geometry.contract.Side;
import geometry.exception.TRITAWrongValueException;

/**
 * A double implementation of the Side interface.
 *
 * Created by egorbachev on 10/7/16.
 */
public class DoubleSideImpl implements Side {
    private static Logger logger = getLogger(DoubleSideImpl.class);

    private double side;

    /**
     * @param side of figure
     */
    public DoubleSideImpl(Object side) throws TRITAWrongValueException {
        if (side instanceof String) {
            try {
                this.side = Double.parseDouble((String) side);
            } catch (NumberFormatException | NullPointerException e) {
                throw new TRITAWrongValueException("Unable to parse value from '" +
                    side + "': " + e);
            }
        } else {
            this.side = (double) side;
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
            Double.compare(side, new Double(other.toString())));
        return Double.compare(side, new Double(other.toString()));
    }
}
