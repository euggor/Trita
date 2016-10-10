package org.euggor.geometry.contract;

/**
 * A base geometric figure interface.
 *
 * Created by egorbachev on 10/7/16.
 */
public interface FigureDescriber /*extends Comparable*/ {
    /**
     *
     * @return figure dimension
     */
    int getDimension();

    /**
     *
     * @return figure type
     */
    String getType();
}
