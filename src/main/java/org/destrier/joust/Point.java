package org.destrier.joust;

/**
 * A point in N dimensional space.
 */
public interface Point {
    /**
     * Returns coordinates array.
     *
     * @return point coodinates. Array should have the same length as number of dimensions.
     */
    double[] getCoordinates();
}
