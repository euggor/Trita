package org.euggor.geometry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.euggor.geometry.contract.FigureDescriber;
import org.euggor.geometry.helper.TriangleDescriberImpl;
import org.euggor.geometry.helper.QuadrilateralDescriberImpl;

/**
 * A standalone invocation wrapper.
 *
 * Created by egorbachev on 10/7/16.
 */
public class IdentifyType {
    private static Logger logger = LogManager.getLogger(IdentifyType.class);

    public static void main(String[] args) {
        FigureDescriber figure = null;
        double[] sides;

        try {
            switch (args.length) {
                case 0:
                    System.out.println("USAGE: IdentifyType side1_length [side2_length [side3_length] [side4_length]]\n" +
                        "\tNote: use clockwise direction for specifying figures of more than 3 sides");
                    System.exit(1);
                case 3: // a triangle figure
                    logger.debug("Triangle figure detected");
                    figure = new TriangleDescriberImpl(convertToInput(args));
                    break;
                case 4: // a quadrilateral figure
                    logger.debug("Quadrilateral figure detected");
                    figure = new QuadrilateralDescriberImpl(convertToInput(args));
                    break;
                default:
                    logger.warn("Unable to identify a figure from the input parameters:");
                    printString(args);
                    System.exit(1);
            }

            logger.info("This is a " + figure + "; Type is " + figure.getType());
        } catch (IllegalArgumentException e) {
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

    private static double[] convertToInput(String[] str) {
        double[] side = new double[str.length];

        int i = 0;
        for (String s: str) {
            side[i] = Double.parseDouble(s);
            i++;
        }

        return side;
    }
}
