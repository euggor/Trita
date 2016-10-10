package geometry.contract;

/**
 * Interface describing a quadrilateral and its possible types.
 *
 * Created by egorbachev on 10/7/16.
 */
public interface QuadrilateralDescriber extends FigureDescriber {
    String TYPE_PARALLELOGRAM = "parallelogram";
    String TYPE_RHOMBUS = "rhombus";
    String TYPE_TRAPEZOID = "trapezoid";
    String TYPE_KITE = "kite";
}
