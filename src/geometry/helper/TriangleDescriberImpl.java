package geometry.helper;

import geometry.contract.Side;
import geometry.contract.TriangleDescriber;
import geometry.exception.TRITAWrongParametersException;
import geometry.exception.TRITAWrongValueException;

/**
 * A triangle implementation of the Figure describer interface.
 *
 * Created by egorbachev on 10/7/16.
 */
public class TriangleDescriberImpl implements TriangleDescriber {
    private Side side1, side2, side3;

    public TriangleDescriberImpl(String[] sides) throws TRITAWrongParametersException {
        if (sides == null || sides.length < 3) {
            throw new TRITAWrongParametersException("Wrong parameters");
        }

        try {
            this.side1 = new FloatSideImpl(sides[0]);
            this.side2 = new FloatSideImpl(sides[1]);
            this.side3 = new FloatSideImpl(sides[2]);
        } catch (TRITAWrongValueException e) {
            throw new TRITAWrongParametersException("Wrong parameters: " +
                e.getMessage());
        }
    }

    public TriangleDescriberImpl(float[] sides) throws TRITAWrongParametersException {
        if (sides == null || sides.length < 3) {
            throw new TRITAWrongParametersException("Wrong parameters");
        }

        try {
            this.side1 = new FloatSideImpl(sides[0]);
            this.side2 = new FloatSideImpl(sides[1]);
            this.side3 = new FloatSideImpl(sides[2]);
        } catch (TRITAWrongValueException e) {
            throw new TRITAWrongParametersException("Wrong parameters: " +
                    e.getMessage());
        }
    }


    public TriangleDescriberImpl(double[] sides) throws TRITAWrongParametersException {
        if (sides == null || sides.length < 3) {
            throw new TRITAWrongParametersException("Wrong parameters");
        }

        try {
            this.side1 = new DoubleSideImpl(sides[0]);
            this.side2 = new DoubleSideImpl(sides[1]);
            this.side3 = new DoubleSideImpl(sides[2]);
        } catch (TRITAWrongValueException e) {
            throw new TRITAWrongParametersException("Wrong parameters: " +
                    e.getMessage());
        }
    }

    @Override
    public int getDimension() {
        return 3;
    }

    @Override
    public String getType() {
        if (side1.compareTo(side2) == 0 & side2.compareTo(side3) == 0 &
                side1.compareTo(side3) == 0) {
            return TYPE_EQUILATERAL;
        } else  if (side1.compareTo(side2) != 0 & side2.compareTo(side3) != 0 &
                side1.compareTo(side3) != 0) {
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
