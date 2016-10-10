package geometry.helper;

import geometry.contract.QuadrilateralDescriber;
import geometry.contract.Side;
import geometry.exception.TRITAWrongParametersException;
import geometry.exception.TRITAWrongValueException;

/**
 * A quadrilateral implementation of the Figure describer interface.
 *
 * Created by egorbachev on 10/7/16.
 */
public class QuadrilateralDescriberImpl implements QuadrilateralDescriber {
    private static final int dimension = 4;
    private Side side1, side2, side3, side4;

    public QuadrilateralDescriberImpl(String[] sides) throws TRITAWrongParametersException {
        if (sides == null || sides.length != dimension) {
            throw new TRITAWrongParametersException("Wrong parameters");
        }

        try { // float values by default
            this.side1 = new FloatSideImpl(sides[0]);
            this.side2 = new FloatSideImpl(sides[1]);
            this.side3 = new FloatSideImpl(sides[2]);
            this.side4 = new FloatSideImpl(sides[3]);
        } catch (TRITAWrongValueException e) {
            throw new TRITAWrongParametersException("Wrong parameters: " +
                e.getMessage());
        }
    }

    public QuadrilateralDescriberImpl(float[] sides) throws TRITAWrongParametersException {
        if (sides == null || sides.length != dimension) {
            throw new TRITAWrongParametersException("Wrong parameters");
        }

        try {
            this.side1 = new FloatSideImpl(sides[0]);
            this.side2 = new FloatSideImpl(sides[1]);
            this.side3 = new FloatSideImpl(sides[2]);
            this.side4 = new FloatSideImpl(sides[3]);
        } catch (TRITAWrongValueException e) {
            throw new TRITAWrongParametersException("Wrong parameters: " +
                    e.getMessage());
        }
    }


    public QuadrilateralDescriberImpl(double[] sides) throws TRITAWrongParametersException {
        if (sides == null || sides.length != dimension) {
            throw new TRITAWrongParametersException("Wrong parameters");
        }

        try {
            this.side1 = new DoubleSideImpl(sides[0]);
            this.side2 = new DoubleSideImpl(sides[1]);
            this.side3 = new DoubleSideImpl(sides[2]);
            this.side4 = new DoubleSideImpl(sides[3]);
        } catch (TRITAWrongValueException e) {
            throw new TRITAWrongParametersException("Wrong parameters: " +
                    e.getMessage());
        }
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public String getType() {
        if (side1.compareTo(side2) == 0 & side2.compareTo(side3) == 0 &
                side1.compareTo(side3) == 0 & side1.compareTo(side4) == 0) {
            return TYPE_RHOMBUS;
        } else if (side1.compareTo(side2) == 0 | side2.compareTo(side3) == 0 |
                side3.compareTo(side4) == 0 | side1.compareTo(side4) == 0) {
            return TYPE_KITE;
        } else if (side1.compareTo(side3) == 0 | side2.compareTo(side4) == 0) {
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
