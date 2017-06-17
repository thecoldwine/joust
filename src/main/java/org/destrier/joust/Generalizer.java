package org.destrier.joust;

import java.util.List;

/**
 * Generalizes polyline or polygon to the similar one.
 */
public interface Generalizer {
    List<Point> generalize(List<Point> points);
}
