package org.euggor.geometry.helper;

import org.euggor.geometry.contract.TriangleDescriber;
import org.euggor.geometry.exception.TRITAWrongValueException;

/**
 * A triangle implementation of the Figure describer interface.
 *
 * Created by egorbachev on 10/7/16.
 */
public class TriangleDescriberImpl implements TriangleDescriber {
    private static final int dimension = 3;
    private double side1, side2, side3;

    public TriangleDescriberImpl(double[] sides) throws IllegalArgumentException {
        if (sides == null || sides.length != dimension) {
            throw new IllegalArgumentException("Wrong sides");
        }

        for (int i=0; i< sides.length; i++) {
            if (sides[i] <= 0) {
               throw new IllegalArgumentException("Side '" + sides[i] +
                    "' is equal or less than zero");
            }
        }

        // Check for inequality based on sides
        if (sides[0] > (sides[1] + sides[2]) | sides[1] > (sides[0] + sides[2]) |
                sides[2] > (sides[0] + sides[1])) {
            throw new IllegalArgumentException("Violation of the triangle inequality");
        }

        this.side1 = sides[0];
        this.side2 = sides[1];
        this.side3 = sides[2];
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public String getType() {
        if (Double.compare(side1, side2) == 0 & Double.compare(side2, side3) == 0 &
                Double.compare(side1, side3) == 0) {
            return TYPE_EQUILATERAL;
        } else  if (Double.compare(side1, side2) != 0 & Double.compare(side2, side3) != 0 &
                Double.compare(side1, side3) != 0) {
            return TYPE_SCALENE;
        } else {
            return TYPE_ISOSCELES;
        }
    }

//    @Override
//    public int compareTo(Object o) {}

    @Override
    public String toString() {
        return getDimension() + "-side figure triangle with side1=[" + side1 + "]; side2=[" + side2 +
            "]; side3=[" + side3 + "]";
    }
}
