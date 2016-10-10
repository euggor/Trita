package org.euggor.geometry.helper;

import org.euggor.geometry.contract.QuadrilateralDescriber;

/**
 * An initial implementation of quadrilateral figure.
 *
 * Created by egorbachev on 10/7/16.
 */
public class QuadrilateralDescriberImpl implements QuadrilateralDescriber {
    private static final int dimension = 4;
    private double side1, side2, side3, side4;

    public QuadrilateralDescriberImpl(double[] sides) throws IllegalArgumentException {
        if (sides == null || sides.length != dimension) {
            throw new IllegalArgumentException("Wrong parameters");
        }

        for (int i=0; i< sides.length; i++) {
            if (sides[i] <= 0) {
                throw new IllegalArgumentException("Side '" + sides[i] +
                        "' is equal or less than zero");
            }
        }

        // TODO: check for inequality

        this.side1 = sides[0];
        this.side2 = sides[1];
        this.side3 = sides[2];
        this.side4 = sides[3];
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public String getType() {
        if (Double.compare(side1, side2) == 0 & Double.compare(side2, side3) == 0 &
                Double.compare(side1, side3) == 0 & Double.compare(side1, side4) == 0) {
            return TYPE_RHOMBUS;
        } else if (Double.compare(side1, side2) == 0 | Double.compare(side2, side3) == 0 |
                Double.compare(side3, side4) == 0 | Double.compare(side1, side4) == 0) {
            return TYPE_KITE;
        } else if (Double.compare(side1, side3) == 0 | Double.compare(side2, side4) == 0) {
            return TYPE_PARALLELOGRAM;
        } else {
            return TYPE_TRAPEZOID;
        }
    }

//    @Override
//    public int compareTo(Object o) {}

    @Override
    public String toString() {
        return getDimension() + "-side figure quadrilateral with side1=[" + side1 + "]; side2=[" + side2 +
            "]; side3=[" + side3 + "]; side4=[" + side4 + "]";
    }
}
