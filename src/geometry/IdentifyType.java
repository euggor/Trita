package geometry;

import geometry.exception.TRITAWrongParametersException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import geometry.contract.FigureDescriber;
import geometry.helper.TriangleDescriberImpl;

/**
 * A standalone invocation wrapper.
 *
 * Created by egorbachev on 10/7/16.
 */
public class IdentifyType {
    private static Logger logger = LogManager.getLogger(IdentifyType.class);

    public static void main(String[] args) {
        FigureDescriber figure = null;

        try {
            switch (args.length) {
                case 0:
                    System.out.println("USAGE: IdentifyType side1_length [side2_length [side3_length] [side4_length]]");
                    System.exit(1);
                case 3: // triangle figure
                    logger.debug("Triangle figure detected");
                    figure = new TriangleDescriberImpl(args);
                    break;
                default:
                    logger.warn("Unable to identify a figure from the input parameters:");
                    printString(args);
                    System.exit(1);
            }

            logger.info("This is a " + figure + "; Type is " + figure.getType());
        } catch (TRITAWrongParametersException e) {
            logger.warn("Some of the input parameters:");
            printString(args);
            logger.warn("is wrong:" + "\n\t" + e.getMessage());
        }
    }

    private static void printString(String[] str) {
        for (String i: str) {
            logger.warn("\t" + i);
        }
    }
}
