package tests;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import geometry.contract.FigureDescriber;
import geometry.helper.TriangleDescriberImpl;
import geometry.exception.TRITAWrongParametersException;

import static geometry.contract.TriangleDescriber.TYPE_ISOSCELES;
import static geometry.contract.TriangleDescriber.TYPE_SCALENE;
import static geometry.contract.TriangleDescriber.TYPE_EQUILATERAL;

/**
 * Created by egorbachev on 10/7/16.
 */
public class TriangleDescriberTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyParameters() throws TRITAWrongParametersException {
        String[] args = {};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void nullParameters() throws TRITAWrongParametersException {
        float[] args = {};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void wrongParameter1() throws TRITAWrongParametersException {
        String[] args = {"", "2", "3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void wrongParameter2() throws TRITAWrongParametersException {
        String[] args = {"1", "", "3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void wrongParameter3() throws TRITAWrongParametersException {
        String[] args = {"1", "2", ""};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void wrongParameters() throws TRITAWrongParametersException {
        String[] args = {"", "", ""};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void nonNumericParameter1() throws TRITAWrongParametersException {
        String[] args = {"a", "2", "3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void nonNumericParameter2() throws TRITAWrongParametersException {
        String[] args = {"1", "b", "3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void nonNumericParameter3() throws TRITAWrongParametersException {
        String[] args = {"1", "2", "a"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void nonNumericParameters() throws TRITAWrongParametersException {
        String[] args = {"a", "b", "c"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void zeroParameter1() throws TRITAWrongParametersException {
        String[] args = {"0", "2", "3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }


    @Test
    public void zeroParameter2() throws TRITAWrongParametersException {
        String[] args = {"1", "0", "3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }


    @Test
    public void zeroParameter3() throws TRITAWrongParametersException {
        String[] args = {"1", "2", "0"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void zeroParameters() throws TRITAWrongParametersException {
        String[] args = {"0", "0", "0"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void negativeParameter1() throws TRITAWrongParametersException {
        String[] args = {"-1", "2", "3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void negativeParameter2() throws TRITAWrongParametersException {
        String[] args = {"1", "-2", "3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void negativeParameter3() throws TRITAWrongParametersException {
        String[] args = {"1", "2", "-3"};

        exception.expect(TRITAWrongParametersException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void scaleneTriangleInt() throws TRITAWrongParametersException {
        String[] args = {"1", "2", "3"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_SCALENE, figure.getType());
    }

    @Test
    public void scaleneTriangleFloat() throws TRITAWrongParametersException {
        String[] args = {"1.1", "2.4", "3.6"}; // Float.parseFloat() is not locale-dependent and expects a dot as decimal separator

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_SCALENE, figure.getType());
    }

    @Test
    public void isoscelesTriangleInt12() throws TRITAWrongParametersException {
        String[] args = {"1", "1", "3"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangleInt23() throws TRITAWrongParametersException {
        String[] args = {"1", "2", "2"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangleInt13() throws TRITAWrongParametersException {
        String[] args = {"1", "2", "1"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangleFloat12() throws TRITAWrongParametersException {
        String[] args = {"1.2008", "1.2008", "3.8"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangleFloat23() throws TRITAWrongParametersException {
        String[] args = {"1.1", "2.1973", "2.1973"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangleFloat13() throws TRITAWrongParametersException {
        String[] args = {"1.2001", "2", "1.2001"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void equilateralTriangleInt() throws TRITAWrongParametersException {
        String[] args = {"1", "1", "1"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_EQUILATERAL, figure.getType());
    }

    @Test
    public void equilateralTriangleFloat() throws TRITAWrongParametersException {
        String[] args = {"1.1974", "1.1974", "1.1974"};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_EQUILATERAL, figure.getType());
    }

    @Test
    public void floatParameters() throws TRITAWrongParametersException {
        float[] args = {(float) 1.19, (float) 1.19, (float) 1.19};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_EQUILATERAL, figure.getType());
    }


    @Test
    public void doubleParameters() throws TRITAWrongParametersException {
        double[] args = {1.1975, 1.1975, 1.1975};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_EQUILATERAL, figure.getType());
    }
}
