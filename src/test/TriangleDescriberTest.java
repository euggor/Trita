package test;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import org.euggor.geometry.contract.FigureDescriber;
import org.euggor.geometry.helper.TriangleDescriberImpl;

import static org.euggor.geometry.contract.TriangleDescriber.TYPE_ISOSCELES;
import static org.euggor.geometry.contract.TriangleDescriber.TYPE_SCALENE;
import static org.euggor.geometry.contract.TriangleDescriber.TYPE_EQUILATERAL;

/**
 * Created by egorbachev on 10/7/16.
 */
public class TriangleDescriberTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyParameters() throws IllegalArgumentException {
        double[] args = {};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void nullParameters() throws IllegalArgumentException {
        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(null);
    }

    @Test
    public void wrongNumberOfParameters() throws IllegalArgumentException {
        double[] args = {2};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void wrongNumberOfParameters2() throws IllegalArgumentException {
        double[] args = {2, 3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void wrongNumberOfParameters4() throws IllegalArgumentException {
        double[] args = {1, 2, 3, 4};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void zeroParameter1() throws IllegalArgumentException {
        double[] args = {0, 2, 3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }


    @Test
    public void zeroParameter2() throws IllegalArgumentException {
        double[] args = {1, 0, 3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }


    @Test
    public void zeroParameter3() throws IllegalArgumentException {
        double[] args = {1, 2, 0};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void zeroParameters() throws IllegalArgumentException {
        double[] args = {0, 0, 0};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void negativeParameter1() throws IllegalArgumentException {
        double[] args = {-1, 2, 3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void negativeParameter2() throws IllegalArgumentException {
        double[] args = {1, -2, 3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void negativeParameter3() throws IllegalArgumentException {
        double[] args = {1, 2, -3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void scaleneTriangleInt() throws IllegalArgumentException {
        double[] args = {1, 2, 3};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_SCALENE, figure.getType());
    }

    @Test
    public void scaleneTriangle() throws IllegalArgumentException {
        double[] args = {1.1, 2.4, 3.2};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_SCALENE, figure.getType());
    }

    @Test
    public void isoscelesTriangleInt12() throws IllegalArgumentException {
        double[] args = {2, 2, 3};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangleInt23() throws IllegalArgumentException {
        double[] args = {1, 2, 2};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangleInt13() throws IllegalArgumentException {
        double[] args = {10, 2, 10};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangle12() throws IllegalArgumentException {
        double[] args = {1.2008, 1.2008, 1.8};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangle23() throws IllegalArgumentException {
        double[] args = {1.1, 2.1973, 2.1973};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void isoscelesTriangle13() throws IllegalArgumentException {
        double[] args = {1.2001, 2, 1.2001};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void equilateralTriangleInt() throws IllegalArgumentException {
        double[] args = {1, 1, 1};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_EQUILATERAL, figure.getType());
    }

    @Test
    public void equilateralTriangle() throws IllegalArgumentException {
        double[] args = {1.1974, 1.1974, 1.1974};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_EQUILATERAL, figure.getType());
    }

    @Test
    public void wrongTriangle1() throws IllegalArgumentException {
        double[] args = {3, 1.1, 0.3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void wrongTriangle2() throws IllegalArgumentException {
        double[] args = {1.1, 2.1, 0.3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void wrongTriangle3() throws IllegalArgumentException {
        double[] args = {1, 1, 3};

        exception.expect(IllegalArgumentException.class);
        FigureDescriber figure = new TriangleDescriberImpl(args);
    }

    @Test
    public void degenerateTriangle1() throws IllegalArgumentException {
        double[] args = {2.2, 1.1, 1.1};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void degenerateTriangle2() throws IllegalArgumentException {
        double[] args = {1.2, 2.4, 1.2};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }

    @Test
    public void degenerateTriangle3() throws IllegalArgumentException {
        double[] args = {1.3, 1.3, 2.6};

        FigureDescriber figure = new TriangleDescriberImpl(args);
        assertEquals(TYPE_ISOSCELES, figure.getType());
    }
}
