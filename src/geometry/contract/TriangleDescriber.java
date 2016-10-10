package geometry.contract;

/**
 * Interface describing a triangle and its possible types.
 *
 * Created by egorbachev on 10/7/16.
 */
public interface TriangleDescriber extends FigureDescriber {
    String TYPE_EQUILATERAL = "equilateral";
    String TYPE_ISOSCELES = "isosceles";
    String TYPE_SCALENE = "scalene";
}
