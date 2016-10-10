package geometry;

import geometry.exception.TRITAWrongParametersException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import geometry.contract.FigureDescriber;
import geometry.helper.TriangleDescriberImpl;
import geometry.helper.QuadrilateralDescriberImpl;

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
                    System.out.println("USAGE: IdentifyType side1_length [side2_length [side3_length] [side4_length]]\n" +
                        "\tNote: use clockwise direction for specifying figures of more than 3 sides");
                    System.exit(1);
                case 3: // a triangle figure
                    logger.debug("Triangle figure detected");
                    figure = new TriangleDescriberImpl(args);
                    break;
                case 4: // a quadrilateral figure
                    logger.debug("Quadrilateral figure detected");
                    figure = new QuadrilateralDescriberImpl(args);
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
